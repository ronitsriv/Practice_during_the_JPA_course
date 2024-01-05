package com.in28minutes.hibernate.demo1.entity;

import jakarta.persistence.*;


@Entity

public class Review {
    @Id
    @GeneratedValue
    private Long id;

    private String rating;
    private String description;

    @ManyToOne
    private Course course;

    public Review() {

    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Review(String number, String description) {

    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Review(String name) {

    }

    public Long getId() {
        return id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return String.format("Review[%s %s]",rating, description);
    }

}
