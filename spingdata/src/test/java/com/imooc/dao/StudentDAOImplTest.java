package com.imooc.dao;

import com.imooc.domain.Student;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StudentDAOImplTest {

    @Test
    public void query() {
        StudentDAO studentDAO = new StudentDAOImpl();
        List<Student> students = studentDAO.query();
        for (Student student : students) {
            System.out.println("id: " + student.getId()
                    + ", name: " + student.getName()
                    + ", age:" + student.getAge());
        }
    }

    @Test
    public void save() {
        StudentDAO studentDAO = new StudentDAOImpl();
        Student student = new Student();
        student.setName("test");
        student.setAge(30);
        studentDAO.save(student);
    }
}