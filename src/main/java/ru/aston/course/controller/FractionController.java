package ru.aston.course.controller;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.aston.course.model.Fraction;
import ru.aston.course.service.FractionService;

import java.util.List;


@RestController
@RequestMapping("/fraction")
public class FractionController {
    FractionService fractionService;

    @Autowired
    public FractionController(FractionService fractionService) {
        this.fractionService = fractionService;
    }
    @GetMapping()
    public List<Fraction> findAll() {

        return fractionService.findAll();
    }
}
