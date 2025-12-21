package me.simjeongman.springbootdeveloper.service;

// AddUserRequest 객체를 인수로 받는 회원 정보 추가 메서드

import lombok.RequiredArgsConstructor;
import me.simjeongman.springbootdeveloper.domain.User;
import me.simjeongman.springbootdeveloper.dto.AddUserRequest;
import me.simjeongman.springbootdeveloper.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto) {
        return userRepository.save(User.builder()
                .email(dto.getEmail())
                // 패스워드 암호화 -> 패스워드를 저장할 때 시큐리티를 설정하여 패스워드 인코딩용으로 등록한 빈을 사용해서 암호화한 후에 저장
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .build()).getId();
    }

    // 전달받은 유저 ID로 유저를 검색해서 전달하는 메서드
    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
    }
}
