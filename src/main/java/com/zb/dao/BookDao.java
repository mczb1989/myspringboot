package com.zb.dao;

import com.zb.model.Book;

import java.util.List;

/**
 * Created by zhangbin on 2018/8/9.
 */
public interface BookDao {
    List<Book> selectAll();
}
