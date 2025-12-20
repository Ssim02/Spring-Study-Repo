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
}
