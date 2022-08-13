package com.epicodeproject.ProgettoSettimana10.model;

import java.util.Date;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String studentId;
    private String name;
    private String surname;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthdate;
    private String email;
    private String address;
    private String city;
    private Degree degree;
}

