package ua.andrii.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ua.andrii.springcourse.model.Person;
import ua.andrii.springcourse.util.PersonRawMapper;

import java.util.List;
import java.util.Optional;

@Component
@Primary
public class PeopleDaoJDBCTemplate implements PeopleDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PeopleDaoJDBCTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Person> getPeopleList() {
        return jdbcTemplate.query("SELECT * FROM Person", new PersonRawMapper());
    }

    @Override
    public Optional<Person> getPersonOptional(int id) {
        List<Person> personList = jdbcTemplate
                .query("SELECT * FROM Person WHERE id = ?", new Object[]{id}, new PersonRawMapper());
        return Optional.of(personList.stream().findFirst().orElse(null));
    }

    @Override
    public void createPerson(Person person) {
        jdbcTemplate.update("INSERT INTO Person (name, age, email) VALUES (?, ?, ?)",
                person.getName(), person.getAge(), person.getEmail());
    }

    @Override
    public void updatePerson(int id, Person person) {
        jdbcTemplate.update("UPDATE Person SET name = ?, age = ?, email = ? WHERE id = ?",
                person.getName(), person.getAge(), person.getEmail(), id);
    }

    @Override
    public void deletePerson(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id = ?", id);
    }

    public Optional<Person> getPersonOptional(String email) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE email = ?",
                        new Object[]{email},
                        new PersonRawMapper() )
                .stream().findAny();
    }
}
