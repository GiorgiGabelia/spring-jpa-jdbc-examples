package com.example.learn_jpa_and_hibernate.course.jpa;

import com.example.learn_jpa_and_hibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {
    // About this annotation: all I know is that it's more specific than @Autowired but probably does the same thing (injects EntityManager bean);
    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course course) {
        entityManager.merge(course);
    }

    public Course selectedById(long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(long id) {
        Course course = selectedById(id);
        entityManager.remove(course);
    }
}
