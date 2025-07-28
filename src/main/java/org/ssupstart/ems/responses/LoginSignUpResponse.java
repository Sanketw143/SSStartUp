package org.ssupstart.ems.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginSignUpResponse {
    private String userName;
    private String action;
    private boolean isSuccess;
}
