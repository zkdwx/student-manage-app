package com.kingstar.mapper;

import com.kingstar.bean.Clbum;
import com.kingstar.bean.Page;
import com.kingstar.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ClbumMapper {

    public List<Student> getClbumList(Page page);

    public int getClbumCount();

    public Clbum getClbumById(Integer id);

    public Integer addClbum(Clbum clbum);

    public Integer updateClbum(Clbum clbum);

    public Integer removeClbum(Integer id);

    public Integer deletedClbum(Integer id);
}
