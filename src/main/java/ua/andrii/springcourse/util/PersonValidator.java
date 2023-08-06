package ua.andrii.springcourse.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.andrii.springcourse.dao.PeopleDao;
import ua.andrii.springcourse.dao.PeopleDaoJDBCTemplate;
import ua.andrii.springcourse.model.Person;

@Component
public class PersonValidator implements Validator {
    private PeopleDaoJDBCTemplate peopleDaoJDBCTemplate;

    @Autowired
    public PersonValidator(PeopleDaoJDBCTemplate peopleDaoJDBCTemplate) {
        this.peopleDaoJDBCTemplate = peopleDaoJDBCTemplate;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        if (peopleDaoJDBCTemplate.getPersonOptional(person.getEmail()).isPresent()) {
            errors.rejectValue("email", "", "Person with this email is already exists in DB");
        }
    }
}
