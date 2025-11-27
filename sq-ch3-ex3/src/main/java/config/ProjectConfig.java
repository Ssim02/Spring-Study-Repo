package config;
import bean.Parrot;
import bean.Person;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    @Bean
    public Parrot parrot() {
        Parrot p = new Parrot();
        p.setName("KoKo");
        return p;
    }

    @Bean
    public Person person(Parrot parrot) { // 메서드에 대한 매개변수를 정의하ㅕ 스프링 컨텍스트에서 빈을 제공하도록 스프링에 지시한다.
        Person p = new Person();
        p.setName("Ella");
        p.setParrot(parrot); // 스프링이 전달한 참조로 사람의 속성 값을 설정한다.
        return p;
    }
}
