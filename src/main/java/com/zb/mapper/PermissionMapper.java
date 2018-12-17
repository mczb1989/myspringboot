package com.zb.mapper;

import com.zb.model.Permission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    @Select("select * from permission where id in (select permission_id from role_permission where role_id = #{roleId})")
    List<Permission> selectPermissionIdByRoleId(@Param("roleId") int roleId);
}