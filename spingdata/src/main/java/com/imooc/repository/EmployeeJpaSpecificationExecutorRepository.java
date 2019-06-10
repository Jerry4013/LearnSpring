package com.imooc.repository;

import com.imooc.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/06/10
 **/

public interface EmployeeJpaSpecificationExecutorRepository
        extends JpaRepository<Employee, Integer>,
        JpaSpecificationExecutor<Employee> {

}
