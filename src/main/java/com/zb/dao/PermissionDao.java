package com.zb.dao;

import com.zb.model.Permission;

import java.util.List;

/**
 * Created by zhangbin on 2018/8/10.
 */
public interface PermissionDao {
    List<Permission> selectPermissionIdByRoleId(int roleId);
}
