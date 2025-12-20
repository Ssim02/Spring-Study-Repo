package me.simjeongman.springbootdeveloper.controller;

// 로그인, 회원 가입 경로로 접근하면 뷰 파일을 연결하는 컨트롤러

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {
    @GetMapping("/login")
    public String login() { // "/login"경로로 저근하면 이 메서드가 login.html을 반환
        return "login";
    }

    @GetMapping("/signup")
    public String signup() { // 위와 동일하게 signup.html을 반환
        return "signup";
    }
}
