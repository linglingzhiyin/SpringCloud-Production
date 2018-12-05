package com.mzj.api.service;

import java.util.List;

import com.mzj.api.entity.authority.SysRole;
import com.mzj.api.entity.vo.RoleVO;


public interface IRoleService {
	
	List<SysRole> findAll() ;
	
	List<SysRole> findRoleByUserId(String userId) ;
	

	List<SysRole> findByRoleNameAndId(String rolename, String id) ;
	

    List<SysRole> searchSysRoleBySysRoleName(String sysRoleName) ;

	List<SysRole> searchSysRoleBySysRoleId(String sysRoleId);

}
