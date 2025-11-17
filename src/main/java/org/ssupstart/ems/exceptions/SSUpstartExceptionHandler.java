package org.ssupstart.ems.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.ssupstart.ems.constants.ExceptionsConstants;
import org.ssupstart.ems.responses.APIResponse;

@RestControllerAdvice("org.ssupstart.ems")
public class SSUpstartExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        if (ex.getRootCause() != null && ex.getRootCause().getMessage().contains("UNIQUE") || ex.getRootCause().getMessage().contains("duplicate")) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Email already exists. Please use a different email.");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Data integrity violation: " + ex.getMessage());
    }


    //ToDo : check this flow properly
    @org.springframework.web.bind.annotation.ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<APIResponse> handleEmailAlreadyExists(EmailAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new APIResponse<>(ex.getMessage(), ExceptionsConstants.SOMETHING_WENT_WRONG, false));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(EmailNotFoundException.class)
    public ResponseEntity<APIResponse> handleEmailNotFound(EmailNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new APIResponse<>(ex.getMessage(), ExceptionsConstants.SOMETHING_WENT_WRONG, false));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<APIResponse> handleEmployeeNotFound(EmployeeNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new APIResponse<>(ex.getMessage(), ExceptionsConstants.SOMETHING_WENT_WRONG, false));
    }
}

