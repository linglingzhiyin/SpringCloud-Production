package com.mzj.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mzj.api.entity.authority.SysPermission;
import com.mzj.api.entity.authority.SysUser;
import com.mzj.api.service.ISysService;

@RestController
public class SysService implements ISysService {

	@RequestMapping(value = "/SysServiceTest", method = RequestMethod.GET)
	public String getTest() {
		return "test";
	}

	@Override
	public SysUser getSysUserByName(String username) {
		return null;
	}

	@Override
	public List<SysPermission> findMenuListByUserId(String userId) {
		return null;
	}

	@Override
	public List<SysPermission> findPermissionListByUserId(String userId) {
		return null;
	}

}
