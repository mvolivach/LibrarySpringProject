package ua.volivach.library.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ua.volivach.library.models.Book;
import ua.volivach.library.models.Person;

import java.sql.*;
import java.util.List;

@Component
public class PersonDAO {
    private static JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() throws SQLException {
        return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) throws SQLException {
        return jdbcTemplate.query("SELECT * FROM person WHERE id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    public List<Book> getBooksByPersonId(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE person_id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));
    }

    public void save(Person person) throws SQLException {
        jdbcTemplate.update("INSERT INTO person(fullname, birthyear)  VALUES(?, ?)", person.getFullname(), person.getBirthyear());
    }

    public void update(int id, Person updatedPerson) throws SQLException {
        jdbcTemplate.update("UPDATE person SET fullname = ?, birthyear = ? WHERE id = ?", updatedPerson.getFullname(), updatedPerson.getBirthyear(), id);
    }

    public void delete(int id) throws SQLException {
        jdbcTemplate.update("DELETE FROM person WHERE id = ?", id);
    }

}
