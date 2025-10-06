package org.ssupstart.ems.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.ssupstart.constants.ExceptionsConstants;
import org.ssupstart.ems.responses.APIResponse;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        if (ex.getRootCause() != null && ex.getRootCause().getMessage().contains("UNIQUE") || ex.getRootCause().getMessage().contains("duplicate")) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Email already exists. Please use a different email.");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Data integrity violation: " + ex.getMessage());
    }


    //ToDo : check this flow properly
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<APIResponse> handleEmailAlreadyExists(EmailAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new APIResponse<>(ex.getMessage(), ExceptionsConstants.SOMETHING_WENT_WRONG, false));
    }

    @ExceptionHandler(EmailNotFoundException.class)
    public ResponseEntity<APIResponse> handleEmailNotFound(EmailNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new APIResponse<>(ex.getMessage(), ExceptionsConstants.SOMETHING_WENT_WRONG, false));
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<APIResponse> handleEmployeeNotFound(EmployeeNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new APIResponse<>(ex.getMessage(), ExceptionsConstants.SOMETHING_WENT_WRONG, false));
    }
}

