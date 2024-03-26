package ru.job4j.persons.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.persons.model.Person;
import ru.job4j.persons.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimplePersonService implements PersonService {

    private final PersonRepository personRepository;

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
        return Optional.of(personRepository.save(person));
    }

    @Override
    public boolean update(Person person) {
        return personRepository.findById(person.getId())
                .map(entity -> {
                    personRepository.save(entity);
                    return true;
                }).orElse(false);
    }

    @Override
    public boolean delete(int id) {
        var person = personRepository.findById(id);
        personRepository.delete(person.get());
        if (!personRepository.findAll().contains(person)) {
            return true;
        } else {
            return false;
        }
    }
}
