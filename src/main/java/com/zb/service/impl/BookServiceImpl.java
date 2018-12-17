package com.zb.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zb.dao.BookDao;
import com.zb.model.Book;
import com.zb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zhangbin on 2018/8/9.
 */
@Component
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public PageInfo selectAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Book> books = bookDao.selectAll();
        PageInfo<Book> pageInfo = new PageInfo<>(books);
        return pageInfo;
    }
}
