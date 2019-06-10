package com.imooc.dao;

import com.imooc.domain.Student;

import java.util.List;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/06/08
 **/

public interface StudentDAO {

    public List<Student> query();

    public void save(Student student);
}
