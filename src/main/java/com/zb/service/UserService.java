package com.zb.service;

import com.github.pagehelper.PageInfo;
import com.zb.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhangbin on 2018/8/6.
 */
public interface UserService {
    User selectByPrimaryKey(Integer id);

    PageInfo<User> selectAll(int pageNum, int pageSize);

    User validateUser(String username, String password);

    int deleteByPrimaryKey(Integer id);

    int insertSelective(User record);

    int updateByPrimaryKeySelective(User record);

    User selectByUsername(String username);

    User findRoleAndPermissions(User user);
}
