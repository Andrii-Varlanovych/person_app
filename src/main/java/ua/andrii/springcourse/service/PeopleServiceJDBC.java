package ua.andrii.springcourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ua.andrii.springcourse.dao.PeopleDao;
import ua.andrii.springcourse.model.Person;
import java.util.List;

@Component
public class PeopleServiceJDBC implements PeopleService {
    private PeopleDao peopleDao;

    @Autowired
    public PeopleServiceJDBC(PeopleDao peopleDao) {
        this.peopleDao = peopleDao;
    }

    @Override
    public List<Person> getPeople() {
        return peopleDao.getPeopleList();
    }

    @Override
    public Person getPersonById(int id) {
        return peopleDao
                .getPersonOptional(id)
                .orElseThrow(()->new RuntimeException("Can't get person with id " + id + " from DB"));
    }

    @Override
    public void createPerson(Person person) {
        peopleDao.createPerson(person);

    }

    @Override
    public void updatePerson(int id, Person person) {
        peopleDao.updatePerson(id, person);
    }

    @Override
    public void deletePerson(int id) {
        peopleDao.deletePerson(id);

    }
}
