package org.j2os.service;

import org.j2os.common.URLWebSocket;
import org.j2os.entity.Person;
import org.j2os.resicord.Try;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    public String savePerson(Person person) {
        return new Try<>(() -> {
            System.out.println("start :" + System.currentTimeMillis());
//            Thread.sleep(5000);
            System.out.println("end :" + System.currentTimeMillis());
            return savePersonS1(person);
        }).whenCatch(e -> savePersonCallBack(person))
                .retry(3, 1000)
                .bulkhead("type1-pool-id", 2, 4, 1000)
                .timeLimit(4000).build();
    }

    public String savePersonCallBack(Person person) {
        return new Try<>(() -> {
            System.out.println("start :" + System.currentTimeMillis());
//            Thread.sleep(5000);
            System.out.println("end :" + System.currentTimeMillis());
            return savePersonS2(person);
        }).whenCatch(e -> "Error: " + e.getMessage())
                .retry(3, 1000)
                .bulkhead("type1-pool-id")
                .timeLimit(6000).build();
    }

    public String findAllPerson() {
        return new Try<>(() -> {
            System.out.println("start :" + System.currentTimeMillis());
//            Thread.sleep(5000);
            System.out.println("end :" + System.currentTimeMillis());
            return findAllPersonS1();
        }).whenCatch(e -> findAllPersonCallBack()).build();
    }

    public String findAllPersonCallBack() {
        return new Try<>(() -> {
            System.out.println("start :" + System.currentTimeMillis());
//            Thread.sleep(5000);
            System.out.println("end :" + System.currentTimeMillis());
            return findAllPersonS2();
        }).whenCatch(e -> "Error: " + e.getMessage()).build();
    }

    public String savePersonS1(Person person) throws Exception {
        String url = ApplicationConfig.HTTP_URL_SERVER1 + "/person/save?name=" + person.getName();
        return URLWebSocket.getStringContent(url);
    }

    public String findAllPersonS1() throws Exception {
        String url = ApplicationConfig.HTTP_URL_SERVER1 + "/person/findAll";
        return URLWebSocket.getStringContent(url);
    }

    public String savePersonS2(Person person) throws Exception {
        String url = ApplicationConfig.HTTP_URL_SERVER2 + "/person/save?name=" + person.getName();
        return URLWebSocket.getStringContent(url);

    }

    public String findAllPersonS2() throws Exception {
        String url = ApplicationConfig.HTTP_URL_SERVER2 + "/person/findAll";
        return URLWebSocket.getStringContent(url);
    }
}

