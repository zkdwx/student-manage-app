package com.kingstar.mapper;

import com.kingstar.bean.Page;
import com.kingstar.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {

    public List<Student> getStudentList(Page page);

    public int getStudentCount();

    public Student getStudentById(Integer id);

    public Integer addStudent(Student student);

    public Integer updateStudent(Student student);

    public Integer removeStudent(Integer id);

    public Integer deletedStudent(Integer id);
}
