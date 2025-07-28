package org.ssupstart.ems.service;

import jakarta.validation.Valid;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.ssupstart.ems.entities.Employee;
import org.ssupstart.ems.repository.EmployeeRepository;
import org.ssupstart.ems.requests.SignUpRequest;
import org.ssupstart.ems.responses.LoginSignUpResponse;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginAndSignUpService {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    EmployeeRepository employeeRepository;

    public LoginSignUpResponse signUpEmployee(SignUpRequest signUpRequest) {
        Employee savedEmp = null;
        String encodedPassword = passwordEncoder.encode(signUpRequest.getPassword());
        try {
            Employee emp = Employee.builder().email(signUpRequest.getEmail()).fullName(signUpRequest.getFullName()).mobileNo(signUpRequest.getMobileNo()).password(encodedPassword).username(signUpRequest.getUsername()).build();
            savedEmp = employeeRepository.save(emp);
        } catch (Exception e) {
            log.error(e.getMessage());
            return LoginSignUpResponse.builder().userName("Invalid").action(e.getMessage()).isSuccess(false).build();
        }
        return LoginSignUpResponse.builder().userName(savedEmp.getUsername()).action("SignUp").isSuccess(true).build();
    }
}
