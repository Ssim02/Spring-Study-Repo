package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);
        Parrot x = new Parrot(); // 스프링 컨텍스트에 추가하고 싶은 인스턴스를 생성
        x.setName("Kiki");

        Supplier<Parrot> parrotSupplier = () -> x; // 이 인스턴스를 반환할 Supplier를 정의
        // registerBean()메서드를 호출하여 이 인스턴스를 스프링 컨텍스트에 추가
        // registerBean(beanName, beanType, 스프링 컨텍스트에 추가하는 객체 인스턴스를 반환하는 Supplier)
        context.registerBean("parrot1", Parrot.class, parrotSupplier);

        // 빈을 기본 빈으로 만들 수 있다. 기본 빈은 컨텍스트에 동일타입의 빈이 여러 개 있을 때,
        // 스프링이 기본적으로 선택할 인스턴스를 정의한다.
        // context.registerBean("parrot1", Parrot.class, parrotSupplier, bc -> bc.setPrimary(true));

        // 컨텍스트에 있는 빈을 검증하려고 앵무새 빈을 참조하여 이름을 콘솔에 출력
        Parrot p = context.getBean(Parrot.class);
        // 컨텍스트에 있는 빈을 검증하려고 앵무새 빈을 참조하여 이름을 콘솔에 출력
        System.out.println(p.getName());
    }
}