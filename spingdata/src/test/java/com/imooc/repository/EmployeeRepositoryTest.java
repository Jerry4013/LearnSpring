package com.imooc.repository;

import com.imooc.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class EmployeeRepositoryTest {

    private ApplicationContext ctx = null;
    private EmployeeRepository employeeRepository = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeRepository = ctx.getBean(EmployeeRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void findByName() {
        Employee aaa = employeeRepository.findByName("aaa");
        System.out.println("aaa = " + aaa.getName());
    }

    @Test
    public void findByNameStartingWithAndAgeLessThan() {
        List<Employee> employees = employeeRepository.findByNameStartingWithAndAgeLessThan("test", 22);
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }
    }

    @Test
    public void findByNameEndingWithAndAgeLessThan() {
        List<Employee> employees = employeeRepository.findByNameEndingWithAndAgeLessThan("6", 23);
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }
    }

    @Test
    public void findByNameInOrAgeLessThan() {
        List<String> names = new ArrayList<>();
        names.add("test1");
        names.add("test2");
        names.add("test3");
        List<Employee> employees = employeeRepository.findByNameInOrAgeLessThan(names, 22);
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }
    }

    @Test
    public void findByNameInAndAgeLessThan() {
        List<String> names = new ArrayList<>();
        names.add("test1");
        names.add("test2");
        names.add("test3");
        List<Employee> employees = employeeRepository.findByNameInAndAgeLessThan(names, 22);
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }
    }

    @Test
    public void getEmployeeByMaxId() {
        Employee employee = employeeRepository.getEmployeeByMaxId();
        System.out.println(employee);
    }

    @Test
    public void queryParams1() {
        List<Employee> employees = employeeRepository.queryParams1("aaa", 21);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void queryParams2() {
        List<Employee> employees = employeeRepository.queryParams2("aaa", 21);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void queryLike1() {
        List<Employee> employees = employeeRepository.queryLike1("test");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void queryLike2() {
        List<Employee> employees = employeeRepository.queryLike2("test1");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void getCount() {
        long count = employeeRepository.getCount();
        System.out.println("count = " + count);
    }



}