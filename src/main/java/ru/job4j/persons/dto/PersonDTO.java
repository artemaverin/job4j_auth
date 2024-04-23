package ru.job4j.persons.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PersonDTO {
    private int id;
    @NotBlank(message = "Password must be not empty")
    private String password;
}
