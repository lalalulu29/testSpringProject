package ru.kirill98.testSpringProject.entity;

import lombok.*;

import java.util.Date;

@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String password;
    private Date regDate;
}
