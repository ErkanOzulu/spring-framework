package stereotype_annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import stereotype_annotations.config.AppConfig;
import stereotype_annotations.model.DataStructure;
import stereotype_annotations.model.ExtraHours;
import stereotype_annotations.model.MicroServices;

public class MyApp {
    public static void main(String[] args) {

        ApplicationContext container=new AnnotationConfigApplicationContext(AppConfig.class);

        MicroServices ms = container.getBean(MicroServices.class);

        ms.getTotalHours();

        DataStructure dsa = container.getBean(DataStructure.class);
        dsa.getTotalHours();

        ExtraHours extraHours = container.getBean(ExtraHours.class);
         System.out.println(extraHours.getHours());;


    }
}
/**
 *TASK 2:
 *     1-Create new package under java stereotype_annotations
 *     2-Create Model and Config Package
 *     3- Under the Model package
 *         -DataStructure
 *         -DevOps
 *         -Microservice
 *     4-Create method for each of them which is getTotalHours() and print some hour
 *             exp: "Total hours: "+20;
 *     5-We only need object from DataStructure and Microservices
 *     6-use Stereotype annotation way to solve it.
 */