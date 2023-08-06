package ua.andrii.springcourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.andrii.springcourse.dao.PeopleDao;
import ua.andrii.springcourse.db.PeopleDB;
import ua.andrii.springcourse.model.Person;

import java.util.List;

@Component
public class PeopleServiceImpl implements PeopleService {
    private PeopleDao peopleDao;

    @Autowired
    public PeopleServiceImpl(PeopleDao peopleDao) {
        this.peopleDao = peopleDao;
    }

    @Override
    public List<Person> getPeople() {
        return peopleDao.getPeopleList();
    }

    @Override
    public Person getPersonById(int id) {
        return peopleDao.getPersonOptional(id)
                .orElseThrow(()->new RuntimeException("Can't get person with id " + id + " from DB"));
    }

    @Override
    public void createPerson(Person person) {
        person.setId(++PeopleDB.PEOPLE_ID);
        peopleDao.createPerson(person);

    }

    @Override
    public void updatePerson(int id, Person updatedPerson) {
        Person personToBeUpdated = peopleDao.getPersonOptional(id)
                .orElseThrow(() -> new RuntimeException("Cant get person with id " + id + " from DB"));
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());

    }

    @Override
    public void deletePerson(int id) {
        peopleDao.deletePerson(id);
    }
}
