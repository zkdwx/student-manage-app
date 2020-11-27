package com.kingstar.controller;

import com.kingstar.bean.Page;
import com.kingstar.response.Response;
import com.kingstar.bean.Student;
import com.kingstar.service.StudentService;
import io.swagger.annotations.ApiOperation;
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
        curPage.setPageSize(page.getPageSize());
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
        Integer result = studentService.deletedStudent(id);
        if (result != null && result > 0) {
            return new Response<>("200", "删除学生信息成功", result);
        } else {
            return new Response<>("500", "删除学生信息失败", result);
        }
    }
}
