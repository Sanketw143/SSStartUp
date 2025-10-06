package org.ssupstart.ems.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest implements Serializable {
    @NotBlank(message = "UserName is required")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;
}
