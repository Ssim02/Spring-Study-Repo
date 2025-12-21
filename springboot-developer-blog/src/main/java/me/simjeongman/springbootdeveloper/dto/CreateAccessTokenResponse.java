package me.simjeongman.springbootdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

// 토큰 생성 응답을 담당하는 DTO
@AllArgsConstructor
@Getter
public class CreateAccessTokenResponse {
    private String accessToken;
}
