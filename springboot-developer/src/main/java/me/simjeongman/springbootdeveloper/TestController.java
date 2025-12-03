package me.simjeongman.springbootdeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


// 프레젠테이션 계층에 속하는 컨트롤러 관련 코드
@RestController // 라우터 역할을 하는 애너테이션
public class TestController { // 이 클래스를 라우터로 지정해 /test라는 GET요청이 왔을 때 test() 메서드를 실행하도록 구성한 것이다.
    @Autowired // TestService 빈 주입
    TestService testService;

    @GetMapping("/test")
    public List<Member> getAllMembers() {
        List<Member> members = testService.getAllMembers();
        return members;
    }
}
