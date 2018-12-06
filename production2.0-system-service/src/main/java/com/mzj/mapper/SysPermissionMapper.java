package com.mzj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mzj.api.entity.authority.SysPermission;

public interface SysPermissionMapper extends BaseMapper<SysPermission> {

	// 根据用户id查询菜单
	@Select("SELECT * FROM sys_permission " + "WHERE TYPE = 'menu' AND id " + "IN (SELECT sys_permission_id "
			+ "FROM sys_role_permission " + "WHERE sys_role_id " + "IN (SELECT sys_role_id " + "FROM sys_user_role "
			+ "WHERE sys_user_id = #{userid}))")
	public List<SysPermission> findMenuListByUserId(String userid);

	// 根据用户id查询权限url
	public String findPermissionByUserId(String userid);

}
