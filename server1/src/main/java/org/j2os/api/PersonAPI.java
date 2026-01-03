package org.j2os.api;

import lombok.RequiredArgsConstructor;
import org.j2os.entity.Person;
import org.j2os.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonAPI {

    private final PersonService personService;

    @GetMapping("/save")
    public Object save(Person person) {
        personService.save(person);
        return person;
    }

    @GetMapping("/findAll")
    public Object findAll() {
        return personService.findAll();
    }
}
