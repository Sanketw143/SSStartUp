package org.ssupstart.ems.requests;


import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OtpVerifyRequest implements Serializable {
    @NotBlank(message = "Otp is required")
    private String otp;

    private Long empid;

}
