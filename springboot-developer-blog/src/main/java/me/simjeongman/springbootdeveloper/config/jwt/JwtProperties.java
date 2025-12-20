package me.simjeongman.springbootdeveloper.config.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/*    jwt를 사용해서 JWT를 생성하고 유효한 토큰인지 검증하는 역할을 하는 클래스    */
@Setter
@Getter
@Component
@ConfigurationProperties("jwt") // 자바 클래스에 프로피티값을 가져와서 사용하는 애너테이션
public class JwtProperties {

    private String issuer; // application.yml에서 설정한 jwt.issuer값이 매핑됨
    private String secretKey; // application.yml에서 설정한 jwt.secret_key 값이 매핑됨

}
