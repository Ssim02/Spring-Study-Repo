package config;

import main.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    Parrot parrot1() {
        var p = new Parrot();
        p.setName("KoKo");
        return p;
    }

    @Bean(name="miki") // 빈 이름을 설정한다.
    Parrot parrot2() {
        var p = new Parrot();
        p.setName("Miki"); // 앵무새 이름을 설정한다.
        return p;
    }

    @Bean
    Parrot parrot3() {
        var p = new Parrot();
        p.setName("Riki");
        return p;
    }

}
