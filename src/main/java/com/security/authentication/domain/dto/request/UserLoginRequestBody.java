package com.security.authentication.domain.dto.request;

import lombok.Getter;

@Getter
public class UserLoginRequestBody {
    private String id;
    private String password;
}
