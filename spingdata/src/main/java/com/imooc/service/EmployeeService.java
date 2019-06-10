package com.imooc.service;

import com.imooc.domain.Employee;
import com.imooc.repository.EmployeeCrudRepository;
import com.imooc.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/06/10
 **/
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    @Transactional
    public void update(Integer id, Integer age){
        employeeRepository.update(id, age);
    }

    @Transactional
    public void saveAll(List<Employee> employees){
        employeeCrudRepository.saveAll(employees);
    }
}
