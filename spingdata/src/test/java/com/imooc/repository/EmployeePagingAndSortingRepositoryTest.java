package com.imooc.repository;

import com.imooc.domain.Employee;
import com.imooc.service.EmployeeService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

public class EmployeePagingAndSortingRepositoryTest {

    private ApplicationContext ctx = null;
    private EmployeePagingAndSoringRepository employeePagingAndSoringRepository = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeePagingAndSoringRepository = ctx.getBean(EmployeePagingAndSoringRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testPage(){
        PageRequest pageRequest = PageRequest.of(0, 5);
        Page<Employee> employeePage = employeePagingAndSoringRepository.findAll(pageRequest);

        System.out.println("Total pages = " + employeePage.getTotalPages());
        System.out.println("Total elements = " + employeePage.getTotalElements());
        System.out.println("Current page number = " + employeePage.getNumber() + 1);
        System.out.println("Content of current page = " + employeePage.getContent());
        System.out.println("Number of elements of current page = " + employeePage.getNumberOfElements());
    }

    @Test
    public void testPageAndSort(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        PageRequest pageRequest = PageRequest.of(0, 5, sort);
        Page<Employee> employeePage = employeePagingAndSoringRepository.findAll(pageRequest);

        System.out.println("Total pages = " + employeePage.getTotalPages());
        System.out.println("Total elements = " + employeePage.getTotalElements());
        System.out.println("Current page number = " + employeePage.getNumber() + 1);
        System.out.println("Content of current page = " + employeePage.getContent());
        System.out.println("Number of elements of current page = " + employeePage.getNumberOfElements());
    }

}