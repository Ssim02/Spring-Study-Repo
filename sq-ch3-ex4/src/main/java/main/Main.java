package main;

import bean.Person;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person p = context.getBean(Person.class);

        System.out.println("Person's name : " + p.getName());
        System.out.println("Person's parrot : " + p.getParrot());
    }
}