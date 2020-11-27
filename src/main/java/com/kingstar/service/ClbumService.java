package com.kingstar.service;

import com.kingstar.bean.Clbum;
import com.kingstar.bean.Page;
import com.kingstar.bean.Student;

import java.util.List;

public interface ClbumService {

    public List<Student> getClbumList(Page page);

    public int getClbumCount();

    public Clbum getClbumById(Integer id);


    public Integer addClbum(Clbum clbum);

    public Integer updateClbum(Clbum clbum);

    public Integer removeClbum(Integer id);

    public Integer deletedClbum(Integer id);
}
