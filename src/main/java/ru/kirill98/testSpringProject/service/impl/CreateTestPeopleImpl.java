package ru.kirill98.testSpringProject.service.impl;

import org.springframework.stereotype.Service;
import ru.kirill98.testSpringProject.entity.Person;
import ru.kirill98.testSpringProject.service.CreateTestPeople;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreateTestPeopleImpl implements CreateTestPeople {
    @Override
    public List<Person> CreatePeople() {
        Person person1 = new Person(1L,
                "Вася",
                "Пупкин",
                28,
                "202cb962ac59075b964b07152d234b70");
        Person person2 = new Person(2L,
                "Вася",
                "Пупкин",
                29,
                "202cb962ac59075b964b07152d234b70");
        Person person3 = new Person(3L,
                "Вася",
                "Пупкин",
                30,
                "202cb962ac59075b964b07152d234b70");
        Person person4 = new Person(3L,
                "Вася",
                "Пупкин",
                39,
                "202cb962ac59075b964b07152d234b70");

        List<Person> people = new ArrayList<>();

        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        return people;
    }
}
