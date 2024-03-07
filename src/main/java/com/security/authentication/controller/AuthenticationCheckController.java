package com.security.authentication.controller;

import com.security.authentication.domain.dto.request.UserLoginRequestBody;
import com.security.authentication.domain.dto.response.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/app/authentication")
public class AuthenticationCheckController {

    @GetMapping("/check")
    public ResponseEntity<?> getAuthenticatedUserInfo (@RequestBody UserLoginRequestBody body) {
        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseBody.builder()
                        .statusCode(HttpStatus.OK)
                        .message("인증된 사용자 입니다.")
                        .build()
        );
    }
}
