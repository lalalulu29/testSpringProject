package ru.kirill98.testSpringProject.service;

import org.springframework.stereotype.Service;
import ru.kirill98.testSpringProject.entity.Person;

import java.util.List;

public interface CreateTestPeople {
    List<Person> CreatePeople();
}
