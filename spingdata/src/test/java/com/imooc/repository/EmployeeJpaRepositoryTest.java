package com.imooc.repository;

import com.imooc.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Example;

import java.util.ArrayList;
import java.util.List;


public class EmployeeJpaRepositoryTest {

    private ApplicationContext ctx = null;
    private EmployeeJpaRepository employeeJpaRepository = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeJpaRepository = ctx.getBean(EmployeeJpaRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void findAllById(){
        List<Integer> ids = new ArrayList<>();
        ids.add(99);
        List<Employee> employees = employeeJpaRepository.findAllById(ids);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void exists(){
        Employee employee = new Employee("test97", 3);
        System.out.println(employeeJpaRepository.exists(Example.of(employee)));
    }







}