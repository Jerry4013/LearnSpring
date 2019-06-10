package com.imooc.repository;

import com.imooc.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/06/10
 **/

public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer> {

}
