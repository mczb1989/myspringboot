package com.zb.dao.impl;

import com.zb.dao.RoleDao;
import com.zb.mapper.RoleMapper;
import com.zb.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zhangbin on 2018/8/10.
 */
@Component
public class RoleDaoImpl implements RoleDao {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> selectRoleByUserId(int userId) {
        return roleMapper.selectRoleByUserId(userId);
    }
}
