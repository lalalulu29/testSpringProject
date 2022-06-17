package ru.kirill98.testSpringProject.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {
    @RequestMapping(value = "rest", method = RequestMethod.GET)
    public String mainRestView() {
        return "{\"request\": \"good\"}";
    }
}
