package com.epicodeproject.ProgettoSettimana10.util;

import com.epicodeproject.ProgettoSettimana10.model.Degree;
import com.epicodeproject.ProgettoSettimana10.model.DummyDb;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class DegreesConverter implements Converter<String,Degree> {

    @Autowired
    ApplicationContext ctx;


    @Override
    public Degree convert(String code) {
        DummyDb db=ctx.getBean(DummyDb.class);
        log.info(db.getDegrees().toString());
        for (Degree d : db.getDegrees()){
            if (d.getCode().equals(code)){
                log.info("Loop broken");
                return d;
            }
        }
        return null;
    }
}
