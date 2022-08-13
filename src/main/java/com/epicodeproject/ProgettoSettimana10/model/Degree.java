package com.epicodeproject.ProgettoSettimana10.model;

import lombok.*;

import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Degree {
    private String code;
    private String name;
    private String degreeAddress;
    private  @Min(value=10,message = "Minimum number of exams have to be at least 10") int examNumber;

}
