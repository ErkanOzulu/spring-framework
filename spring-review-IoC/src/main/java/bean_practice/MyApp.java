package bean_practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {
    public static void main(String[] args) {


        //how to create a spring container?
        ApplicationContext container=new AnnotationConfigApplicationContext(AppConfig.class, AnotherConfig.class);

        FullTimeEmployee fullTimeEmployee = container.getBean(FullTimeEmployee.class);
        fullTimeEmployee.createAccount();

        PartTimeEmployee partTimeEmployee = container.getBean(PartTimeEmployee.class);
        partTimeEmployee.createAccount();

        String str1 = container.getBean("String 1",String.class);
        System.out.println(str1);
        String str2 = container.getBean("str2",String.class);
        System.out.println(str2);



    }
}
/**
 *TASK 1:
 *     1-create new module spring-review-IoC
 *     2-Add spring core dependency
 *     3-create one package named bean_practice
 *     4-Create 2 classes
 *         -FullTimeEmployee
 *         -PartTimeEmployee
 *     5-Create one method for each class createAccount() -print something (void)
 *     6-get beans using spring core @Bean annotation
 *       ----------
 *     7-we need two String object
 *         "Welcome to CydeoApp"
 *         "Spring Core Practice"
 *     8-print those two objects in the same project.(with new config file)
 */