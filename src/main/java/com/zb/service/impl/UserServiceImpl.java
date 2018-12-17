package com.zb.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zb.dao.PermissionDao;
import com.zb.dao.RoleDao;
import com.zb.dao.UserDao;
import com.zb.model.Permission;
import com.zb.model.Role;
import com.zb.model.User;
import com.zb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangbin on 2018/8/6.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<User> selectAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userDao.selectAll();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }

    @Override
    public User validateUser(String username, String password) {
        return userDao.selectByUsernamePass(username, password);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(User record) {
        return userDao.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public User selectByUsername(String username) {
        return userDao.selectByUsername(username);
    }

    @Override
    public User findRoleAndPermissions(User user) {
        List<Role> roleList = roleDao.selectRoleByUserId(user.getId());
        user.setRoleList(roleList);

        List<Permission> permissions = new ArrayList<>();
        for (Role role: roleList) {
            List<Permission> permissionlist = permissionDao.selectPermissionIdByRoleId(role.getId());
            role.setPermissionList(permissionlist);
            permissions.addAll(permissionlist);
        }
        user.setPermissionList(permissions);
        return user;
    }
}
