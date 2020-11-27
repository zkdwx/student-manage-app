package com.kingstar.service;

import com.kingstar.bean.Clbum;
import com.kingstar.bean.Page;
import com.kingstar.bean.Student;
import com.kingstar.mapper.ClbumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClbumServiceImpl implements ClbumService {
    @Autowired
    private ClbumMapper clbumMapper;

    @Override
    public List<Student> getClbumList(Page page) {
        return clbumMapper.getClbumList(page);
    }

    @Override
    public int getClbumCount() {
        return clbumMapper.getClbumCount();
    }

    @Override
    public Clbum getClbumById(Integer id) {
        Clbum clbum = clbumMapper.getClbumById(id);
        return clbum;
    }

    @Override
    public Integer addClbum(Clbum clbum) {
        return clbumMapper.addClbum(clbum);
    }

    @Override
    public Integer updateClbum(Clbum clbum) {
        return clbumMapper.updateClbum(clbum);
    }

    @Override
    public Integer removeClbum(Integer id) {
        return clbumMapper.removeClbum(id);
    }

    @Override
    public Integer deletedClbum(Integer id) {
        return clbumMapper.deletedClbum(id);
    }
}
