package com.epicodeproject.ProgettoSettimana10.util;

import com.epicodeproject.ProgettoSettimana10.config.DegreeConfig;
import com.epicodeproject.ProgettoSettimana10.config.StudentConfig;
import com.epicodeproject.ProgettoSettimana10.model.Degree;
import com.epicodeproject.ProgettoSettimana10.model.DummyDb;
import com.epicodeproject.ProgettoSettimana10.model.Student;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class DataInitTest implements CommandLineRunner {

    @Autowired
ApplicationContext ctx;


    @Override
    public void run(String... args) throws Exception {
        DummyDb db=ctx.getBean(DummyDb.class);
        testFillDB(db);
        log.info(db.getDegrees().toString());
        log.info(db.getStudents().toString());
        log.info("Test Data added");
    }

    public void testFillDB(DummyDb db){
        ctx=new AnnotationConfigApplicationContext(StudentConfig.class);
        db.getStudents().add((Student)ctx.getBean("studentTest1"));
        db.getStudents().add((Student)ctx.getBean("studentTest2"));

        ctx=new AnnotationConfigApplicationContext(DegreeConfig.class);
        db.getDegrees().add((Degree) ctx.getBean("degreeTest1"));
        db.getDegrees().add((Degree) ctx.getBean("degreeTest2"));

    }
}
