package org.example;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // 스프링 컨텍스트의 인스턴스를 생성한다.
        // 스프링 컨텍스트 인스턴스가 생성될 때 구성 클래스를 매개변수로 전송하여 스프링이 이를 사용하도록 지시한다.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Parrot p = context.getBean(Parrot.class); // 스프링 컨텍스트에서 Parrot타입의 빈 참조를 가져온다.
        System.out.println(p.getName());
        String s = context.getBean(String.class);
        System.out.println(s);
        Integer n =  context.getBean(Integer.class);
        System.out.println(n);
    }
}