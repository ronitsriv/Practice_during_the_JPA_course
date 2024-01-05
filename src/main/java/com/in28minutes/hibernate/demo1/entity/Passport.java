package com.in28minutes.hibernate.demo1.entity;

import jakarta.persistence.*;


@Entity

public class Passport {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String number;

    @OneToOne(fetch = FetchType.LAZY,  mappedBy = "passport")
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Passport() {

    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public Passport(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }


    @Override
    public String toString() {
        return String.format("Passport[%s]", number);
    }

}
