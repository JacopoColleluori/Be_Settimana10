package com.epicodeproject.ProgettoSettimana10.model;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
@Data
@Log4j2
public class DummyDb {
    private List<Student> students = new ArrayList<>();
    private List<Degree> degrees = new ArrayList<>();

    public Student getStudentById(String id) {
        Student s = new Student();
        for (Student student : getStudents()) {
            if (student.getStudentId().equals(id)) {
                s = student;
            }
        }
        return s;
    }

    public Degree getDegreeByCode(String code) {
        Degree d = new Degree();
        for (Degree degree : getDegrees()) {
            if (degree.getCode().equals(code)) {
                d = degree;
            }
        }
        return d;
    }
    public void deleteStudent(String id) {
        getStudents().removeIf(student -> id.equals(student.getStudentId()));
    }
    public void deleteDegree(String code) {
       getDegrees().removeIf(degree-> code.equals(degree.getCode()));
    }


    public void updateStudent(String id, Student s) {
        for (Student student : getStudents()) {
            if (student.getStudentId().equals(id)) {
                s.setStudentId(id);
                getStudents().set(getStudents().indexOf(student), s);
            }
        }
    }



    public void updateDegree(String code, Degree d) {
        for (Degree degree : getDegrees()) {
            if (degree.getCode().equals(code)) {
                d.setCode(code);
                getDegrees().set(getDegrees().indexOf(degree), d);
            }
        }
    }
}
