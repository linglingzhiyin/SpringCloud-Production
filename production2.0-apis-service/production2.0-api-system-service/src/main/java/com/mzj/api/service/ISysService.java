package com.mzj.api.service;

import java.util.List;

import com.mzj.api.entity.authority.SysPermission;
import com.mzj.api.entity.authority.SysUser;


public interface ISysService {
	SysUser getSysUserByName(String username);

	List<SysPermission> findMenuListByUserId(String userId);

	List<SysPermission> findPermissionListByUserId(String userId);
}
