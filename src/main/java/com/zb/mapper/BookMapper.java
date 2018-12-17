package com.zb.mapper;

import com.zb.model.Book;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    @Select("Select * from book")
    List<Book> selectAll();
}