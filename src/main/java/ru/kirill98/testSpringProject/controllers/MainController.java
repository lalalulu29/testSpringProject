package ru.kirill98.testSpringProject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kirill98.testSpringProject.service.CreateTestPeople;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class MainController {
    @Value("${message.server.danger}")
    private String dangerMessage;
    private final CreateTestPeople testPeople;



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainView(Model model,
                           @RequestParam(value = "age") Optional<String> age) {
        model.addAttribute("age", age.orElse(""));
        model.addAttribute("people", testPeople.CreatePeople());
        model.addAttribute("messageError", dangerMessage);

        return "index";
    }
}
