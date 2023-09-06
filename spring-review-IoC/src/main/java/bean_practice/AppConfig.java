package bean_practice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

@Bean
public FullTimeEmployee fullTimeEmployee(){
    return new FullTimeEmployee();
}

@Bean
    public PartTimeEmployee partTimeEmployee(){
    return new PartTimeEmployee();
}
}
