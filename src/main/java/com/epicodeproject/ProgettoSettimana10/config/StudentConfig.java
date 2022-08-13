package com.epicodeproject.ProgettoSettimana10.config;

import com.epicodeproject.ProgettoSettimana10.model.Degree;
import com.epicodeproject.ProgettoSettimana10.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Date;

@Configuration
public class StudentConfig {
    ApplicationContext ctx=new AnnotationConfigApplicationContext(DegreeConfig.class);

    @Bean
    @Scope("prototype")
    public Student student(){
        Student s = new Student();
        return s;
    }

    @Bean
    public Student studentTest1(){
        Student s = new Student("asdawrf213","salve","salute", new Date(114180240000l),"sasso@gmail.com","via Salve 230","Salute",(Degree)ctx.getBean("degreeTest1"));
        return s;
    }
    @Bean
    public Student studentTest2(){
        Student s = new Student("infinite23","ave","et tu", new Date(-1573606800000l),"sasso@SPQR.rom","Salara 1","ROME",(Degree)ctx.getBean("degreeTest2"));
        return s;
    }
}
