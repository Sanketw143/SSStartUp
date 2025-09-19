package org.ssupstart.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.ssupstart.constants.APIPathConstants;
import org.ssupstart.ems.service.LoginAndSignUpService;

@Controller
@RequestMapping("/ems")
public class HealthCheckController {
    @Autowired
    LoginAndSignUpService loginAndSignUpService;

    @GetMapping(APIPathConstants.HEALTH_CHECK_PATH)
    public ResponseEntity<?> getHealthCheck() {
        return ResponseEntity.status(200).body("I am healthy employee system");
    }

    @PostMapping(APIPathConstants.HEALTH_CHECK_PATH)
    public ResponseEntity<?> getHealthCheckAfterLogin(@RequestParam("token") String token) {
        if(loginAndSignUpService.validateToken(token))
            return ResponseEntity.status(200).body("I am healthy employee system");
        else
            return ResponseEntity.status(500).body("User logged out");
    }
}
