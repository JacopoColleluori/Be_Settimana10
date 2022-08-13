package com.epicodeproject.ProgettoSettimana10.controller;


import com.epicodeproject.ProgettoSettimana10.model.Degree;
import com.epicodeproject.ProgettoSettimana10.model.DummyDb;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Log4j2
@Controller
@RequestMapping("/degree")
public class DegreeController {
    @Autowired
    ApplicationContext ctx ;


    @GetMapping("/addForm")
    public String addNewDegree(Model model) {
        Degree d = new Degree();
        model.addAttribute("degree", d);
        return "addDegree";
    }

    @GetMapping("/updateForm/{id}")
    public String putDegree(Model model, @PathVariable String id) {
        DummyDb db =  ctx.getBean(DummyDb.class);
        Degree d = db.getDegreeByCode(id);
        //log.info(s.toString());
        model.addAttribute("degree", d);
        return "addDegree";
    }

    @PostMapping("/addDegree")
    public String addDegree(@Valid Degree d, Model model,BindingResult res) {
        DummyDb db =  ctx.getBean(DummyDb.class);
        if(res.hasErrors()){
            model.addAttribute("degree",d);
            return "addDegree";
        }
        db.getDegrees().add(d);
        log.info(db.getDegrees().toString());
        model.addAttribute("degrees", db.getDegrees());
        //new ModelAndView("studentList","students" ,db.getStudents());
        return "redirect:/degree/view";
    }

    @PostMapping("/updateDegree/{id}")
    public String updateDegree(Model model, @PathVariable String id, @Valid Degree d, BindingResult res) {
        DummyDb db =  ctx.getBean(DummyDb.class);
        if(res.hasErrors()){
            model.addAttribute("degree",d);
            return "updateDegree/"+d.getCode();
        }
        db.updateDegree(id, d);
        log.info(db.getStudents().toString());
        model.addAttribute("degrees", db.getDegrees());
        return "redirect:/degree/view";
    }

    @GetMapping("/view")
    public String getDegreeList(Model model) {
        DummyDb db =  ctx.getBean(DummyDb.class);
        model.addAttribute("degrees", db.getDegrees());
        return "degreeList";
    }


    @GetMapping("/delete/{id}")
    public String deleteDegree(Model model, @PathVariable String id) {
        DummyDb db =  ctx.getBean(DummyDb.class);
        log.info(id);
        db.deleteDegree(id);
        model.addAttribute("degrees", db.getDegrees());
        log.info(db.getDegrees().toString());
        return "redirect:/degree/view";
    }
}
