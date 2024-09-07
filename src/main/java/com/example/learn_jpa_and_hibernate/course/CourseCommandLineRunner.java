package com.example.learn_jpa_and_hibernate.course;

import com.example.learn_jpa_and_hibernate.course.jdbc.CourseJdbcRepository;
import com.example.learn_jpa_and_hibernate.course.jpa.CourseJpaRepository;
import com.example.learn_jpa_and_hibernate.course.spring_data_jpa.SpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
    @Autowired
    private CourseJdbcRepository jdbcRepository;

    @Autowired
    private CourseJpaRepository jpaRepository;

    @Autowired
    private SpringDataJpaRepository springDataJpaRepository;


    // Class implementing this interface is used for intro logic when running spring application
    @Override
    public void run(String... args) throws Exception {
        executeQueriesFromSpringDataJPARepo();
    }

    private void executeQueriesFromJDBCRepo() {
        jdbcRepository.insert(new Course("Givi", "Java 1", 0));
        jdbcRepository.insert(new Course("Givi", "Java 2", 1));
        jdbcRepository.insert(new Course("Givi", "Java 3", 2));

        jdbcRepository.deleteById(0);

        jdbcRepository.selectedById(1);
    }

    private void executeQueriesFromJPARepo() {
        jpaRepository.insert(new Course("Givi", "Java 1", 0));
        jpaRepository.insert(new Course("Givi", "Java 2", 1));
        jpaRepository.insert(new Course("Givi", "Java 3", 2));

        jpaRepository.deleteById(1);

        Course course = jpaRepository.selectedById(2);
        System.out.println(course);
    }

    private void executeQueriesFromSpringDataJPARepo() {
        springDataJpaRepository.save(new Course("Givi", "Java 1", 0));
        springDataJpaRepository.save(new Course("Givi", "Java 2", 1));
        springDataJpaRepository.save(new Course("Giovanni", "Spring boot", 2));

//        springDataJpaRepository.deleteById(1L);

        Optional<Course> course = springDataJpaRepository.findById(2L);
        course.ifPresent(
                c -> {
                    System.out.println(c);
                    ;
                }
        );

        System.out.println(springDataJpaRepository.findByAuthor("Givi"));
    }


}
