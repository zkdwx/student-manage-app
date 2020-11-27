package com.kingstar.controller;

import com.kingstar.bean.Clbum;
import com.kingstar.bean.Page;
import com.kingstar.bean.Student;
import com.kingstar.response.Response;
import com.kingstar.service.ClbumService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clbum")
public class ClbumController {
    @Autowired
    private ClbumService clbumService;

    @ApiOperation("查询班级信息列表")
    @PostMapping("/getClbumList")
    public Response<Page> getClbumList(@RequestBody Page page) {
        int totalRecords = clbumService.getClbumCount();
        Page curPage = new Page(page.getCurrentPageNum(), totalRecords);
        curPage.setPageSize(page.getPageSize());
        List<Student> list = clbumService.getClbumList(curPage);
        curPage.setRecords(list);
        return new Response<>("200", "查询成功", curPage);
    }

    @ApiOperation("根据班级id查询班级信息")
    @GetMapping("/getClbumById")
    public Response<Clbum> getClbumInfo(Integer id) {
        Clbum clbum = clbumService.getClbumById(id);
        return new Response<>("200", "查询成功", clbum);
    }

    @ApiOperation("新增班级信息")
    @PostMapping("/addClbum")
    public Response<Integer> addClbum(@RequestBody Clbum clbum) {
        Integer result = clbumService.addClbum(clbum);
        if (result != null && result > 0) {
            return new Response<>("200", "新增班级成功", result);
        } else {
            return new Response<>("500", "新增班级失败", result);
        }
    }

    @ApiOperation("修改班级信息")
    @PostMapping("/updateClbum")
    public Response<Integer> updateClbum(@RequestBody Clbum clbum){
        Integer result = clbumService.updateClbum(clbum);
        if (result != null && result > 0) {
            return new Response<>("200", "修改班级信息成功", result);
        } else {
            return new Response<>("500", "修改班级信息失败", result);
        }
    }

    @ApiOperation("删除班级信息")
    @PostMapping("/removeClbum")
    public Response<Integer> removeClbum(Integer id){
        Integer result = clbumService.removeClbum(id);
        if (result != null && result > 0) {
            return new Response<>("200", "删除班级信息成功", result);
        } else {
            return new Response<>("500", "删除班级信息失败", result);
        }
    }

    @ApiOperation("删除班级信息")
    @DeleteMapping("/deletedClbum")
    public Response<Integer> deletedClbum(Integer id){
        Integer result = clbumService.deletedClbum(id);
        if (result != null && result > 0) {
            return new Response<>("200", "删除班级信息成功", result);
        } else {
            return new Response<>("500", "删除班级信息失败", result);
        }
    }
}
