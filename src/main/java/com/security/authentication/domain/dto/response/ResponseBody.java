package com.security.authentication.domain.dto.response;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public record ResponseBody<T>(HttpStatus statusCode, String message, T data) {
}
