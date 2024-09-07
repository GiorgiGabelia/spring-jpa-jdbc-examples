package com.example.learn_jpa_and_hibernate.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
// If the bean name doesn't match the sql table name, we can do: (name = 'table-name-here')
public class Course {
    @Id
    private long id;

    private String author;
    private String name;
    // If the field name doesn't match the sql column name, we can do: @Column(name = 'column-name-here')


    public Course(String author, String name, long id) {
        this.author = author;
        this.name = name;
        this.id = id;
    }

    public Course() {
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Course{" +
                "author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
