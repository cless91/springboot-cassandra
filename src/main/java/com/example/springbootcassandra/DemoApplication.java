package com.example.springbootcassandra;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@Slf4j
public class DemoApplication implements ApplicationRunner {

  @Autowired private PersonRepository personRepository;

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
//    personRepository.save(
//        new Person(
//            new PersonKey("julien", LocalDateTime.now(), UUID.randomUUID()),
//            "mbimbi-bene",
//            38000.0));
//    List<Person> persons = personRepository.findByLastName("mbimbi-bene");
//    persons.stream().map(Person::toString).forEach(log::info);

		List<Person> persons = personRepository.findByKeyFirstName("julien");
    persons.stream().map(Person::toString).forEach(log::info);
  }
}
