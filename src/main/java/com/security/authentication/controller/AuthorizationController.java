package com.security.authentication.controller;

import com.security.authentication.domain.dto.data.UserDataDTO;
import com.security.authentication.domain.dto.request.UserLoginRequestBody;
import com.security.authentication.domain.dto.response.ResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Slf4j
@RestController
@RequestMapping("/api/v1")
public class AuthorizationController {
    @GetMapping("/test")
    public ResponseEntity<?> test () {
        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseBody.builder()
                        .statusCode(HttpStatus.OK)
                        .message("테스트 인증에 성공하였습니다.")
                        .build()
        );
    }

    @PostMapping("/authorization")
    public ResponseEntity<?> login (@RequestBody UserLoginRequestBody body) {
        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseBody.builder()
                        .statusCode(HttpStatus.OK)
                        .message("인증에 성공하였습니다.")
                        .data(body)
                        .build()
        );
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup (@RequestBody UserDataDTO body) {
        System.out.println(body);
        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseBody.builder()
                        .statusCode(HttpStatus.OK)
                        .message("회원가입에 성공하였습니다.")
                        .data(body)
                        .build()
        );
    }
}
