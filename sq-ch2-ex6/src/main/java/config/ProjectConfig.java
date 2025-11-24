package config;

import main.Parrot;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="main") // 애너테이션의 basePackages 속성으로 스프링에 스테레오 타입 애너테이션이 지정된 클래스를 찾을 위치를 알려 준다.
public class ProjectConfig {
    Parrot parrot1() {
        var p = new Parrot();
        // p.setName("");
        return p;
    }
    Parrot parrot2() {
        var p = new Parrot();
        return p;
    }
}
