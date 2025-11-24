package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p = context.getBean(Parrot.class);
        System.out.println(p); // 스프링 컨텍스트에서 가져온 인스턴스를 기본 String 형식으로 출력

        // System.out.println(p.getName()); // 스프링이 컨텍스트에 추가한 Parrot 인스턴스에 아직 이름 지정 X -> null이 출력
        System.out.println(p.getName()); // @PostConstruct로 인스턴스에 이름이 들어갔다?
    }
}