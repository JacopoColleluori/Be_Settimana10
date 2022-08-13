package com.epicodeproject.ProgettoSettimana10.controller;

import com.epicodeproject.ProgettoSettimana10.model.Degree;
import com.epicodeproject.ProgettoSettimana10.model.DummyDb;
import com.epicodeproject.ProgettoSettimana10.model.Student;
import com.epicodeproject.ProgettoSettimana10.util.DegreesConverter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Controller
@RequestMapping("/student")

public class StudentController {
    @Autowired
    ApplicationContext ctx;

    @Autowired
    DegreesConverter converter;

    Degree d;

    @GetMapping("/addForm")
    public String addNewStudent(Model model) {
        DummyDb db = ctx.getBean(DummyDb.class);
        Student s = new Student();
        model.addAttribute("student", s);
        model.addAttribute("degrees", db.getDegrees());
        log.info(db.getDegrees().toString());
        return "addStudent";
    }

    @GetMapping("/updateForm/{id}")
    public String putStudent(Model model, @PathVariable String id) {
        DummyDb db = ctx.getBean(DummyDb.class);
        Student s = db.getStudentById(id);
        log.info(db.getDegrees().toString());
        model.addAttribute("student", s);
        model.addAttribute("degrees", db.getDegrees());
        return "addStudent";
    }

    @PostMapping("/addStudent")
    public String addStudent(Student s, Model model) {
        DummyDb db = ctx.getBean(DummyDb.class);
        d = converter.convert(s.getDegree().getCode());
        s.setDegree(d);
        db.getStudents().add(s);
        log.info(db.getStudents().toString());
        model.addAttribute("students", db.getStudents());
        return "redirect:/student/view";
    }

    @PostMapping("/updateStudent/{id}")
    public String updateStudent(Model model, @PathVariable String id, Student s) {
        DummyDb db = ctx.getBean(DummyDb.class);
        log.info(s.getDegree().getCode());
        d = converter.convert(s.getDegree().getCode());
        s.setDegree(d);
        db.updateStudent(id, s);
        log.info(db.getStudents().toString());
        model.addAttribute("students", db.getStudents());
        return "redirect:/student/view";
    }

    @GetMapping("/view")
    public String getStudentList(Model model) {
        DummyDb db = ctx.getBean(DummyDb.class);
        model.addAttribute("students", db.getStudents());
        log.info(db.getStudents().toString());
        return "studentList";
    }


    @GetMapping("/delete/{id}")
    public String deleteStudent(Model model, @PathVariable String id) {
        DummyDb db = ctx.getBean(DummyDb.class);
        log.info(id);
        db.deleteStudent(id);
        model.addAttribute("students", db.getStudents());
        log.info(db.getStudents());
        return "redirect:/student/view";
    }
}
