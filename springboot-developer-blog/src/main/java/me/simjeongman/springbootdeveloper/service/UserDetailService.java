package me.simjeongman.springbootdeveloper.service;

/*  스프링 시큐리티에서 로그인을 진행할 때 사용자 정보를 가져오는 서비스 메서드 코드   */

import lombok.RequiredArgsConstructor;
import me.simjeongman.springbootdeveloper.domain.User;
import me.simjeongman.springbootdeveloper.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
// 스프링 시큐리티에서 사용자 정보를 가져오는 인터페이스
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    // 사용자 이름(email)로 사용자의 정보를 가져오는 메서드
    // 필수로 구현해야하는 loadUserByUsername()메서드를 오버라이딩해서 사용자 정보를 가져오는 로직을 작성
    @Override
    public User loadUserByUsername(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException(email));
    }
}
