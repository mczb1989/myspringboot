package com.zb.service;

import com.github.pagehelper.PageInfo;

/**
 * Created by zhangbin on 2018/8/9.
 */
public interface BookService {
    PageInfo selectAll(int pageNum, int pageSize);
}
