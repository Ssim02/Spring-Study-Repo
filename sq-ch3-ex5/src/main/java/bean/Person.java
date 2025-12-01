package bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

    private String name = "Ella";
    private final Parrot parrot; // 필드를 final로 설정하여 초기화한 후 값을 변경할 수 없게 한다.

    @Autowired // 생성자에 애너테이션을 사용한다.
    public Person(Parrot parrot) {
        this.parrot = parrot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot;
    }

    /*
    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }
     */
}
