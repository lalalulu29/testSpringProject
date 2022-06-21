package ru.kirill98.testSpringProject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kirill98.testSpringProject.entity.Person;
import ru.kirill98.testSpringProject.service.CreateTestPeople;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class MainController {
    @Value("${message.server.danger}")
    private String dangerMessage;

    @Value("${message.server.error}")
    private String errorMessage;

    private final CreateTestPeople testPeople;
    private static final List<Person> persons = new ArrayList<>();



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainView(Model model,
                           @RequestParam(value = "age") Optional<String> age) {
        model.addAttribute("title", "Test Title");
        model.addAttribute("age", age.orElse(""));
        if(persons.isEmpty()) {
            persons.addAll(testPeople.CreatePeople());
        }
        model.addAttribute("people",persons);

        model.addAttribute("messageError", dangerMessage);
        System.out.println("Was got GET request");
        return "index";
    }
    @RequestMapping(value = "new_person", method = RequestMethod.GET)
    public String createPersonView(Model model) {
        Person newPerson = new Person();
        model.addAttribute("person", newPerson);
        return "newPerson";
    }
    @RequestMapping(value = "new_person", method = RequestMethod.POST)
    public String createPerson(Model model, @ModelAttribute("Person") Person newPerson) {
        if(newPerson.getFirstName() != null &&
                newPerson.getFirstName().length() > 0 &&
                newPerson.getLastName() != null &&
                newPerson.getLastName().length() > 0) {
            persons.add(newPerson);
            return "redirect:/";
        }
        model.addAttribute("person", newPerson);
        model.addAttribute("errorMessage", errorMessage);
        return "newPerson";
    }
}
