package ru.kirill98.testSpringProject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kirill98.testSpringProject.entity.FormPerson;
import ru.kirill98.testSpringProject.entity.Person;
import ru.kirill98.testSpringProject.service.CreateTestPeople;
import ru.kirill98.testSpringProject.service.PersonMapper;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@RequiredArgsConstructor
@Controller
public class MainController {
    @Value("${message.server.danger}")
    private String dangerMessage;

    @Value("${message.server.error}")
    private String errorMessage;

    @Value("${message.server.notEqualsPassword}")
    private String notEqualsPassword;

    private final CreateTestPeople testPeople;
    private final PersonMapper personMapper;
    private static final List<Person> persons = new ArrayList<>();
    private static long count = 6;



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
        return "index";
    }
    @RequestMapping(value = "new_person", method = RequestMethod.GET)
    public String createPersonView(Model model) {
        FormPerson newPerson = new FormPerson();
        model.addAttribute("person", newPerson);
        model.addAttribute("notEqualsPassword", notEqualsPassword);
        return "newPerson";
    }
    @RequestMapping(value = "new_person", method = RequestMethod.POST)
    public String createPerson(Model model, @ModelAttribute("Person") FormPerson newPerson) throws NoSuchAlgorithmException {
        if(newPerson.getFirstName() != null &&
                newPerson.getFirstName().length() > 0 &&
                newPerson.getLastName() != null &&
                newPerson.getLastName().length() > 0 &&
                newPerson.getPassword() != null &&
                newPerson.getPassword().length() >= 8 &&
                newPerson.getCheckPassword().equals(newPerson.getPassword())) {

            newPerson.setAge(null);
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(newPerson.getPassword().getBytes(StandardCharsets.UTF_8));
            byte[] md5Password = messageDigest.digest();
            BigInteger bigInt = new BigInteger(1,md5Password);
            StringBuilder hashText = new StringBuilder(bigInt.toString(16));
            while(hashText.length() < 32 ){
                hashText.insert(0, "0");
            }
            newPerson.setPassword(hashText.toString());

            Person personFromFormPerson = personMapper.toPerson(newPerson, count);
            persons.add(personFromFormPerson);
            count++;
            return "redirect:/";
        }
        model.addAttribute("person", newPerson);
        model.addAttribute("errorMessage", errorMessage);
        model.addAttribute("notEqualsPassword", notEqualsPassword);
        return "newPerson";
    }
}
