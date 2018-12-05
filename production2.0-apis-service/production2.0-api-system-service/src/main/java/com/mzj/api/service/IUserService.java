package com.mzj.api.service;

import java.util.List;

import com.mzj.api.entity.authority.SysUser;


public interface IUserService {

	SysUser getUser(String string);
	
	List<SysUser> findByUserNameAndId(String username, String id) ;

    List<SysUser> searchSysUserBySysUserName(String sysUserName) ;

	List<SysUser> searchSysUserBySysUserId(String sysUserId) ;

}
