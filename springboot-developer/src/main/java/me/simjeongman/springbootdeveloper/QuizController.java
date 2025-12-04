package me.simjeongman.springbootdeveloper;

import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuizController {

    @GetMapping("/quiz") // quiz 패스로 GET요청이 오면 quiz()라는 메서드에서 요청을 처리.
    // 이 메서드는 요청 파라미터의 키가 "code"이면 int 자료형의 code변수와 매핑되며, code의 값에 따라 다른 응답을 보낸다.
    public ResponseEntity<String> quiz(@RequestParam("code") int code) {
        switch (code) {
            case 1: // 응답 코드 : 201
                return ResponseEntity.created(null).body("Created!");
            case 2: // 웅답 코드 : 400
                return ResponseEntity.badRequest().body("Bad request!");
            default: // 그 외의 응답 코드 : 200
                return ResponseEntity.ok().body("OK!");
        }
    }

    @PostMapping("/quiz") // quiz패스로 POST요청이 오면, quiz2()라는 메서드에서 요청을 처리.
    // 이 메서드는 요청 값을 Code라는 객체로 매핑한 후에, value값에 따라 다른 응답을 보냄.
    public ResponseEntity<String> quiz2(@RequestBody Code code) {

        switch (code.value()) {
            case 1: // 응답 코드 : 403
                return ResponseEntity.status(403).body("Forbidden!");
            default: // 그 외 응답 코드 : 200
                return ResponseEntity.ok().body("OK!");
        }
    }
}

record Code(int value) {} // POST요청에서 매핑할 객체로 사용하기 위해 선언한 레코드.
