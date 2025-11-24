package main;

import beans.Parrot;
import beans.Person;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // 구성 클래스(ProjectConfig)를 기반으로 스프링 컨텍스트 인스턴스를 생성
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // 스프링 컨텍스트에서 Person 빈의 참조를 얻는다.
        Person person = context.getBean(Person.class);

        // 스프링 컨텍스트에서 Parrot 빈의 참조를 얻는다.
        Parrot parrot = context.getBean(Parrot.class);

        // 스프링 컨텍스트의 Person 빈인지 확인하려고 이름을 출력한다.
        System.out.println("Person's name : " + person.getName());

        // 스프링 컨텍스트의 Parrot 빈인지 확인하려고 이름을 출력한다.
        System.out.println("Parrot name : " + parrot.getName());

        // 인스턴스 사이의 관계 여부를 확인하려고 Person 빈의 Parrot을 출력한다.
        System.out.println("Person's parrot : " + person.getParrot());
    }
}