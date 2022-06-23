package ru.kirill98.testSpringProject.service;

import ru.kirill98.testSpringProject.entity.FormPerson;
import ru.kirill98.testSpringProject.entity.Person;

public interface PersonMapper {
    Person toPerson(FormPerson formPerson, Long count);
    FormPerson toFormPerson(Person person);
}
