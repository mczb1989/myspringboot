package com.zb.dao;

import com.zb.model.Role;

import java.util.List;

/**
 * Created by zhangbin on 2018/8/10.
 */
public interface RoleDao {
    List<Role> selectRoleByUserId(int userId);
}
