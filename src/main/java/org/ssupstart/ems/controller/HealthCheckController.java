package org.ssupstart.ems.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ssupstart.constants.APIPathConstants;
import org.ssupstart.ems.responses.APIResponse;

@Controller
@RequestMapping("/ems")
public class HealthCheckController {
    @GetMapping(APIPathConstants.HEALTH_CHECK_PATH)
    public ResponseEntity<?> getHealthCheck() {
        return ResponseEntity.status(200).body("I am healthy employee system");
    }
}
