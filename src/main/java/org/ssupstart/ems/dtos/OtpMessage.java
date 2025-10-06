package org.ssupstart.ems.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OtpMessage {
    private String phone;
    private String otp;
    private Long empId;
    private String email;
}
