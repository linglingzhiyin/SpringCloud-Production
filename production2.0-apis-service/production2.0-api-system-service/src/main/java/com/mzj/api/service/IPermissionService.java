package com.mzj.api.service;

import java.util.List;

import com.mzj.api.entity.authority.SysRolePermission;


public interface IPermissionService {
	
	List<SysRolePermission> findAll();  

	SysRolePermission getRolePermissionById(String id)  ;
	
	SysRolePermission getRolePermissionByRoleId(String roleId);
}
