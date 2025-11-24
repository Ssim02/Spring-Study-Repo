package config;


import org.example.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 이 애터테이션을 사용하여 이 클래스를 스프링 구성 클래스로 정의한다.
public class ProjectConfig {

    @Bean
        // @Bean 애너테이션을 추가하여 스프링에 컨텍스트가 초기화 될 때 이 메서드를 호출하고,
          // 반환된 값을 컨텍스트에 추가하라고 지시한다.
    Parrot parrot() { // 이 메서드 이름이 빈의 이름이 된다.
        var p = new Parrot();
        p.setName("KoKo"); // 나중에 앱을 테스트할 때를 대비해서 Parrot에 이름을 설정.

        return p; // 스프링은 메서드가 반환한 Parrot인스턴스를 컨텍스트에 추가한다.
    }

    @Bean // 스프링 컨텍스트에 "Hello" 문자열 추가
    String hello() {
        return "Hello";
    }

    @Bean // 스프링 컨텍스트에 정수 10 추가
    Integer ten() {
        return 10;
    }
}
