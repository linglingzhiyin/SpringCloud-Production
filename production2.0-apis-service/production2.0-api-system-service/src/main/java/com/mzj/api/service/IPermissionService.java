package com.mzj.api.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mzj.api.entity.authority.SysRolePermission;

public interface IPermissionService {

	List<SysRolePermission> findAll();

	SysRolePermission getRolePermissionById(String id);

	SysRolePermission getRolePermissionByRoleId(String roleId);

	@RequestMapping(value = "/checkPermission")
	@ResponseBody
	public boolean checkPermission(String username,String password,String url);

}
