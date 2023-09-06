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
