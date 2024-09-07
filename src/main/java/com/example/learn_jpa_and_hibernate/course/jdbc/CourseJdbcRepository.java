package com.example.learn_jpa_and_hibernate.course.jdbc;

import com.example.learn_jpa_and_hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private final static String INSERT_QUERY = """
                insert into course(id, name, author)
                VALUES (?, ?, ?);
            """;
    private final static String DELETE_BY_ID_QUERY = """
                delete from course
                where id = ?;
            """;

    private final static String SELECT_BY_ID_QUERY = """
                select * from course
                where id = ?;
            """;

    public void insert(Course course) {
        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long courseId) {
        springJdbcTemplate.update(DELETE_BY_ID_QUERY, courseId);
    }

    public void selectedById(long id) {
        // BeanPropertyRowMapper will basically map the queried row to a bean created by Spring, setting values with setters on that class;
        // From docs:
        // RowMapper implementation that converts a row into a new instance of the specified mapped target class. The mapped target class must be a top-level class or static nested class, and it must have a default or no-arg constructor.
        Course result = springJdbcTemplate.queryForObject(SELECT_BY_ID_QUERY, new BeanPropertyRowMapper<>(Course.class), id);

        System.out.println(result);
    }

}
