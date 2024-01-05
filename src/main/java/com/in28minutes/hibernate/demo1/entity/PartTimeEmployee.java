package com.in28minutes.hibernate.demo1.entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class PartTimeEmployee extends Employee{
    protected PartTimeEmployee(){}

    public PartTimeEmployee(String name, BigDecimal hourlyWage){
        super(name);
        this.hourlyWage = hourlyWage;
    }
    private BigDecimal hourlyWage;
}
