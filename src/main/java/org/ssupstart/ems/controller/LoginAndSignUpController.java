package org.ssupstart.ems.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ssupstart.constants.APIPathConstants;
import org.ssupstart.ems.requests.SignUpRequest;
import org.ssupstart.ems.responses.APIResponse;
import org.ssupstart.ems.responses.LoginSignUpResponse;
import org.ssupstart.ems.service.LoginAndSignUpService;

@RestController
@RequestMapping("/ems")
public class LoginAndSignUpController {

    @Autowired
    LoginAndSignUpService loginAndSignUpService;

    @PostMapping(APIPathConstants.SIGN_UP_PATH)
    public ResponseEntity<APIResponse<LoginSignUpResponse>> signupController(@Valid @RequestBody SignUpRequest signUpRequest) {
        LoginSignUpResponse response = loginAndSignUpService.signUpEmployee(signUpRequest);
        if(response.isSuccess()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(new APIResponse<>(response, "Employee successfully created", true));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new APIResponse<>(response, response.getAction(), false));
        }
    }
}
