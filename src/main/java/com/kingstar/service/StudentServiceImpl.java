package com.kingstar.service;

import com.kingstar.bean.Page;
import com.kingstar.bean.Student;
import com.kingstar.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> getStudentList(Page page) {
        return studentMapper.getStudentList(page);
    }

    @Override
    public int getStudentCount() {
        return studentMapper.getStudentCount();
    }

    @Override
    public Student getStudentById(Integer id) {
        Student student = studentMapper.getStudentById(id);
        return student;
    }

    @Override
    public Integer addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    @Override
    public Integer updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public Integer removeStudent(Integer id) {
        return studentMapper.removeStudent(id);
    }

    @Override
    public Integer deletedStudent(Integer id) {
        return studentMapper.deletedStudent(id);
    }
}
