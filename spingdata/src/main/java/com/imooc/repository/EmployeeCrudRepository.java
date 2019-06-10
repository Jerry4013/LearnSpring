package com.imooc.repository;

import com.imooc.domain.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/06/10
 **/

public interface EmployeeCrudRepository extends CrudRepository<Employee, Integer> {

}
