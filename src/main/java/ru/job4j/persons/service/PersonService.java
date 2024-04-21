package ru.job4j.persons.service;

import ru.job4j.persons.dto.PersonDTO;
import ru.job4j.persons.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> findAll();
    Optional<Person> findById(int id);
    Optional<Person> save(Person person);
    boolean update(Person person);
    Optional<Person> updatePassword(PersonDTO personDTO);
    boolean delete(Person person);
}
