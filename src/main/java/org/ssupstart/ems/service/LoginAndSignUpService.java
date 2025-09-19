package org.ssupstart.ems.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.ssupstart.ems.dtos.OtpMessage;
import org.ssupstart.ems.entities.Employee;
import org.ssupstart.ems.exceptions.EmailAlreadyExistsException;
import org.ssupstart.ems.exceptions.EmployeeNotFoundException;
import org.ssupstart.ems.exceptions.InvalidCredentialsException;
import org.ssupstart.ems.repository.EmployeeRepository;
import org.ssupstart.ems.requests.LoginRequest;
import org.ssupstart.ems.requests.OtpVerifyRequest;
import org.ssupstart.ems.requests.SignUpRequest;
import org.ssupstart.ems.responses.LoginSignUpResponse;

import java.time.Duration;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginAndSignUpService {

    private final Duration SESSION_TTL = Duration.ofSeconds(30);

    private final RedisTemplate<String, Object> redisTemplate;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    private KafkaTemplate<String, OtpMessage> kafkaTemplate;

    public LoginSignUpResponse signUpEmployee(SignUpRequest signUpRequest) {
        Employee savedEmp = null;
        String encodedPassword = passwordEncoder.encode(signUpRequest.getPassword());
        try {
            validateEmailIsAlreadyPresentOrNot(signUpRequest);
            //ToDo: check builder pattern peoperly
            Employee emp = Employee.builder().email(signUpRequest.getEmail()).fullName(signUpRequest.getFullName()).mobileNo(signUpRequest.getMobileNo()).password(encodedPassword).username(signUpRequest.getUsername()).build();
            savedEmp = employeeRepository.save(emp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
        return LoginSignUpResponse.builder().userName(savedEmp.getUsername()).action("SignUp").isSuccess(true).build();
    }

    //Similarly we can do for mobile and other unique fields
    private void validateEmailIsAlreadyPresentOrNot(SignUpRequest signUpRequest) {
        Employee e = employeeRepository.getByEmail(signUpRequest.getEmail());
        if(Objects.nonNull(e)) {
            throw new EmailAlreadyExistsException("This email is already present");
        }
    }

    public LoginSignUpResponse loginEmployee(@Valid LoginRequest loginRequest) {
        Employee e = employeeRepository.getByUsername(loginRequest.getUsername());
        if (Objects.isNull(e)) {
            throw new EmployeeNotFoundException("This username is not present");
        }

        if (!passwordEncoder.matches(loginRequest.getPassword(), e.getPassword())) {
            throw new InvalidCredentialsException("Invalid password");
        }

        String otp = String.format("%06d", new Random().nextInt(900_000) + 100_000);
        redisTemplate.opsForValue().set("OTP:"+ otp +"#"+e.getId(),e,SESSION_TTL);
        OtpMessage topic = new OtpMessage(e.getMobileNo(),otp,e.getId(), e.getEmail());
        kafkaTemplate.send("test", topic);
        return LoginSignUpResponse.builder().userName(e.getUsername()).generatedOtp(otp).action("login").isSuccess(true).build();
    }

    public boolean validateToken(String token) {
        return redisTemplate.hasKey("SESSION:" + token);
    }

    public LoginSignUpResponse verifyOtp(@Valid OtpVerifyRequest otpVerifyRequest) {
        if(redisTemplate.hasKey("OTP:"+ otpVerifyRequest.getOtp() +"#"+ otpVerifyRequest.getEmpid())) {
            Employee e = employeeRepository.getById(otpVerifyRequest.getEmpid());
            String sessionToken = UUID.randomUUID().toString() + e.getUsername();
            redisTemplate.opsForValue().set("SESSION:" + sessionToken, e, SESSION_TTL);
            return LoginSignUpResponse.builder().userName(e.getUsername()).sessionToken(sessionToken).action("login").isSuccess(true).build();
        } else {
            throw new EmployeeNotFoundException("Otp is not valid");
        }
    }
}
