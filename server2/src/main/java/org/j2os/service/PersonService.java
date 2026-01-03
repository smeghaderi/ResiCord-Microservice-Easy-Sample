package org.j2os.service;

import lombok.RequiredArgsConstructor;
import org.j2os.entity.Person;
import org.j2os.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public void save(Person person) {
        person.setName("S2."+person.getName());
        personRepository.save(person);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }
}
