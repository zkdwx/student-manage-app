package com.kingstar.controller;

import com.kingstar.bean.Page;
import com.kingstar.response.Response;
import com.kingstar.bean.Student;
import com.kingstar.service.StudentService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ApiOperation("查询学生信息列表")
    @PostMapping("/getStudentList")
    public Response<Page> getStudentList(@RequestBody Page page) {
        int totalRecords = studentService.getStudentCount();
        Page curPage = new Page(page.getCurrentPageNum(), totalRecords);
        //校验分页大小，限定50
        int size = Math.min(page.getPageSize(), 50);
        if (size <= 0) size = 0;
        curPage.setPageSize(size);
        List<Student> list = studentService.getStudentList(curPage);
        curPage.setRecords(list);
        return new Response<>("200", "查询成功", curPage);
    }


    @ApiOperation("根据学生id查询学生信息")
    @GetMapping("/getStudentInfo")
    public Response<Student> getStudentInfo(Integer id) {
        Student student = studentService.getStudentById(id);
        return new Response<>("200", "查询成功", student);
    }

    @ApiOperation("新增学生信息")
    @PostMapping("/addStudent")
    public Response<Integer> addStudent(@RequestBody Student student) {
        if (StringUtils.isBlank(student.getName())
                || student.getClassId() == null
                || student.getAge() == null) {
            throw new RuntimeException("字段不能为空");
        }
        Integer result = studentService.addStudent(student);
        if (result != null && result > 0) {
            return new Response<>("200", "新增学生成功", result);
        } else {
            return new Response<>("500", "新增学生失败", result);
        }
    }

    @ApiOperation("修改学生信息")
    @PostMapping("/updateStudent")
    public Response<Integer> updateStudent(@RequestBody Student student) {
        if (StringUtils.isBlank(student.getName())
                || student.getClassId() == null
                || student.getAge() == null) {
            throw new RuntimeException("字段不能为空");
        }
        Student s = studentService.getStudentById(student.getId());
        if (s == null) {
            return new Response<>("200", "该学生不存在！", null);
        }
        Integer result = studentService.updateStudent(student);
        if (result != null && result > 0) {
            return new Response<>("200", "修改学生信息成功", result);
        } else {
            return new Response<>("500", "修改学生信息失败", result);
        }
    }

    @ApiOperation("删除学生信息")
    @PostMapping("/removeStudent")
    public Response<Integer> removeStudent(Integer id) {
        Student s = studentService.getStudentById(id);
        if (s == null) {
            return new Response<>("200", "该学生不存在！", null);
        }
        Integer result = studentService.removeStudent(id);
        if (result != null && result > 0) {
            return new Response<>("200", "删除学生信息成功", result);
        } else {
            return new Response<>("500", "删除学生信息失败", result);
        }
    }

    @ApiOperation("删除学生信息")
    @DeleteMapping("/deletedStudent")
    public Response<Integer> deletedStudent(Integer id) {
        Student s = studentService.getStudentById(id);
        if (s == null) {
            return new Response<>("200", "该学生不存在！", null);
        }
        Integer result = studentService.deletedStudent(id);
        if (result != null && result > 0) {
            return new Response<>("200", "删除学生信息成功", result);
        } else {
            return new Response<>("500", "删除学生信息失败", result);
        }
    }
}
