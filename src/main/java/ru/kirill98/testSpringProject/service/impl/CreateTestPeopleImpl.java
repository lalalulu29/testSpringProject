package ru.kirill98.testSpringProject.service.impl;

import org.springframework.stereotype.Service;
import ru.kirill98.testSpringProject.entity.Person;
import ru.kirill98.testSpringProject.service.CreateTestPeople;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class CreateTestPeopleImpl implements CreateTestPeople {
    @Override
    public List<Person> CreatePeople() {
        Person person1 = new Person().toBuilder()
                .id(1L)
                .firstName("Вася")
                .lastName("Пупкин")
                .age(21)
                .password("202cb962ac59075b964b07152d234b70")
                .regDate(new Date())
                .build();
        Person person2 = new Person().toBuilder()
                .id(2L)
                .firstName("Вася")
                .lastName("Пупкин")
                .age(26)
                .password("202cb962ac59075b964b07152d234b70")
                .regDate(new Date())
                .build();
        Person person3 = new Person().toBuilder()
                .id(3L)
                .firstName("Вася")
                .lastName("Пупкин")
                .age(30)
                .password("202cb962ac59075b964b07152d234b70")
                .regDate(new Date())
                .build();
        Person person4 = new Person().toBuilder()
                .id(4L)
                .firstName("Вася")
                .lastName("Пупкин")
                .age(39)
                .password("202cb962ac59075b964b07152d234b70")
                .regDate(new Date())
                .build();
        Person person5 = new Person().toBuilder()
                .id(5L)
                .firstName("Кирилл")
                .lastName("Гульков")
                .age(23)
                .password("3062dd4532690f15db1de4e7b5406d8d")
                .regDate(new Date())
                .build();

        return Arrays.asList(person1, person2, person3, person4, person5);
    }
}
