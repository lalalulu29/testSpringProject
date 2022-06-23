package ru.kirill98.testSpringProject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormPerson {
    private String firstName;
    private String lastName;
    private Integer age;
    private String password;
    private String checkPassword;
}
