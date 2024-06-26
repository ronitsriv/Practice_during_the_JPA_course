package com.in28minutes.hibernate.demo1.entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class FullTimeEmployee extends Employee{
    protected FullTimeEmployee(){}

    public FullTimeEmployee(String name, BigDecimal salary){
        super(name);
        this.salary = salary;
    }
    private BigDecimal salary;
}
