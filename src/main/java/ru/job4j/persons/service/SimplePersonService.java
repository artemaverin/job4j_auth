package ru.job4j.persons.service;

import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.job4j.persons.model.Person;
import ru.job4j.persons.repository.PersonRepository;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class SimplePersonService implements PersonService {

    private PersonRepository personRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(SimplePersonService.class);
    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Optional<Person> findById(int id) {
        return personRepository.findById(id);
    }

    @Override
    public Optional<Person> save(Person person) {
        try {
            Person savedPerson = personRepository.save(person);
            return Optional.of(savedPerson);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return Optional.empty();
    }

    public boolean update(Person person) {
        boolean result = false;
        var updatePerson = personRepository.findById(person.getId());
        if (updatePerson.isPresent()) {
            personRepository.save(updatePerson.get());
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(Person person) {
        boolean result = false;
        var updatePerson = personRepository.findById(person.getId());
        if (updatePerson.isPresent()) {
            personRepository.delete(updatePerson.get());
            result = true;
        }
        return result;
    }
}
