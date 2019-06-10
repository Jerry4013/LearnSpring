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
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

import static org.junit.Assert.*;

public class EmployeeJpaSpecificationExecutorRepositoryTest {

    private ApplicationContext ctx = null;
    private EmployeeJpaSpecificationExecutorRepository employeeJpaSpecificationExecutorRepository = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeJpaSpecificationExecutorRepository = ctx.getBean(EmployeeJpaSpecificationExecutorRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void query(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(0, 5, sort);

        Specification<Employee> specification = new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root root,
                                         CriteriaQuery criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {
                Path path = root.get("age");
                return criteriaBuilder.gt(path, 50);
            }
        };

        Page<Employee> employeePage = employeeJpaSpecificationExecutorRepository.findAll(specification, pageable);

        System.out.println("Total pages = " + employeePage.getTotalPages());
        System.out.println("Total elements = " + employeePage.getTotalElements());
        System.out.println("Current page number = " + employeePage.getNumber() + 1);
        System.out.println("Content of current page = " + employeePage.getContent());
        System.out.println("Number of elements of current page = " + employeePage.getNumberOfElements());
    }
}