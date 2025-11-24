package main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component // 클래스에 대해 이 애너테이션을 사용하면, 스프링은 이 클래스의 인스턴스를 생성하고 스프링 컨텍스트에 추가.
public class Parrot {

    private String name;
    public String getName() {
        return name;
    }

    @PostConstruct
    public void init() {
        this.name = "Kiki";
    }
}
