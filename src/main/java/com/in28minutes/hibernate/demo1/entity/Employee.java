package com.in28minutes.hibernate.demo1.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


//@Entity
@MappedSuperclass
//@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="EmployeeType")
public abstract class Employee {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    protected Employee(){}
    public Employee(String name){
        this.name=name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Employee[%s]", name);
    }
}
