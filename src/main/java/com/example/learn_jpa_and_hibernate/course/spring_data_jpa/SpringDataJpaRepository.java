package com.example.learn_jpa_and_hibernate.course.spring_data_jpa;

import com.example.learn_jpa_and_hibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// The generics are what's the entity to be managed, and the type of primary key (annotated with @Id in the entity)
public interface SpringDataJpaRepository extends JpaRepository<Course, Long> {

    // We can define custom abstract methods like this:
    List<Course> findByAuthor(String author);
    //Format is <doSomethingBy>By<entity field name>
    
    List<Course> findByName(String name);
}
