package me.simjeongman.springbootdeveloper.dto;

// 토큰 생성 요청을 담당할 DTO

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAccessTokenRequest {
    private String refreshToken;
}
