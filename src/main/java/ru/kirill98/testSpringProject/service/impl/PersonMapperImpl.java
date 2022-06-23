package ru.kirill98.testSpringProject.service.impl;

import org.springframework.stereotype.Service;
import ru.kirill98.testSpringProject.entity.FormPerson;
import ru.kirill98.testSpringProject.entity.Person;
import ru.kirill98.testSpringProject.service.PersonMapper;

import java.util.Date;

@Service
public class PersonMapperImpl implements PersonMapper {
    @Override
    public Person toPerson(FormPerson formPerson, Long count) {
        return new Person().toBuilder()
                .id(count)
                .firstName(formPerson.getFirstName())
                .lastName(formPerson.getLastName())
                .age(formPerson.getAge())
                .password(formPerson.getPassword())
                .regDate(new Date())
                .build();
    }

    @Override
    public FormPerson toFormPerson(Person person) {
        return new FormPerson().toBuilder()
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .age(person.getAge())
                .password(person.getPassword())
                .build();
    }
}
