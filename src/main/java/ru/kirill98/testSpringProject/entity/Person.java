package ru.kirill98.testSpringProject.entity;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @NotNull
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private Integer age;
    @NotNull
    private String password;
    @NotNull
    private Date regDate;
}
