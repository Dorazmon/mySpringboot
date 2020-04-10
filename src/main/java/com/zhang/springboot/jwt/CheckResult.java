package com.zhang.springboot.jwt;

import io.jsonwebtoken.Claims;
import lombok.Data;

@Data
public class CheckResult {
    private boolean success;
    private Claims claims;
    private String errCode;
}
