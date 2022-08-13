package com.epicodeproject.ProgettoSettimana10.config;

import com.epicodeproject.ProgettoSettimana10.model.Degree;
import com.epicodeproject.ProgettoSettimana10.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Date;

@Configuration
public class DegreeConfig {

    @Bean
    @Scope("prototype")
    public Degree degree(){
        Degree d = new Degree();
        return d;
    }

    @Bean
    public Degree degreeTest1(){
       Degree d = new Degree("saxophone","Music","Musicology",11);
        return d;
    }
    @Bean
    public Degree degreeTest2() {
        Degree d = new Degree("personalComputer", "IT", "Science", 111);
        return d;
    }
}
