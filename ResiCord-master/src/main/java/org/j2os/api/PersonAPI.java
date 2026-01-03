package org.j2os.api;

import lombok.RequiredArgsConstructor;
import org.j2os.entity.Person;
import org.j2os.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Amirsam Bahador, Ali Ghaderi and Mohammad Ghaderi in 2025.
 * Version: 1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonAPI {

    private final PersonService personService;

    @GetMapping("/save")
    public Object save(Person person) {
        return personService.savePerson(person);
    }

    @GetMapping("/findAll")
    public Object findAll() {
        return personService.findAllPerson();
    }

}
