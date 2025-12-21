package me.simjeongman.springbootdeveloper.repository;

import me.simjeongman.springbootdeveloper.domain.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    // Optional<T> : NullPointerException 방지를 위해서 사용.
    // Optional<T> : 내부가 비어있을 수도 있고, 채워져 있을 수도 있는 상자이다.
    Optional<RefreshToken> findByUserId(Long userId); // userId를 기준으로 DB에서 리프레시 토큰을 찾는다
    Optional<RefreshToken> findByRefreshToken(String refreshToken); // 토큰 문자열 값 자체로 DB를 검색한다.
}
