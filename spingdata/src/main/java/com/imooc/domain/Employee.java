package com.imooc.domain;

import javax.persistence.*;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/06/09
 **/
@Entity
@Table(name = "test_employee")
public class Employee {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 50)
    private String name;

    private Integer age;

    public Employee() {
    }

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
