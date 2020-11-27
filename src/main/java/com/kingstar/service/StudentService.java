package com.kingstar.service;

import com.kingstar.bean.Page;
import com.kingstar.bean.Student;
import io.swagger.models.auth.In;

import java.util.List;

public interface StudentService {

    public List<Student> getStudentList(Page page);

    public int getStudentCount();


    public Student getStudentById(Integer id);

    public Integer addStudent(Student student);

    public Integer updateStudent(Student student);

    public Integer removeStudent(Integer id);

    public Integer deletedStudent(Integer id);
}
