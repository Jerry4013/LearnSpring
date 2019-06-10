package com.imooc.repository;

import com.imooc.domain.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/06/10
 **/

public interface EmployeePagingAndSoringRepository extends PagingAndSortingRepository<Employee, Integer> {
}
