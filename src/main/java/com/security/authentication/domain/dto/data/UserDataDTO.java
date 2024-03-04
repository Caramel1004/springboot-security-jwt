package com.security.authentication.domain.dto.data;

import lombok.Data;

@Data
public class UserDataDTO {
    private String id;
    private String password;
    private String role;
    private String gender;

}
