package ua.andrii.springcourse.service;

import ua.andrii.springcourse.model.Person;

import java.util.List;

public interface PeopleService {

    List<Person> getPeople();

    Person getPersonById(int id);

    void createPerson(Person person);

    void updatePerson(int id, Person person);

    void deletePerson(int id);
}
