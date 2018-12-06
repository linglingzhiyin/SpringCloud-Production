package com.mzj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mzj.api.entity.authority.SysPermission;
import com.mzj.api.entity.authority.SysRolePermission;
import com.mzj.api.entity.authority.SysUser;
import com.mzj.api.entity.authority.SysUserRole;
import com.mzj.api.service.ISysService;
import com.mzj.mapper.SysPermissionMapper;
import com.mzj.mapper.SysRolePermissionMapper;
import com.mzj.mapper.SysUserMapper;
import com.mzj.mapper.SysUserRoleMapper;

@RestController
@RequestMapping("/SysService")
public class SysService implements ISysService {

	@Autowired
	private SysUserMapper sysUserMapper;
	@Autowired
	private SysPermissionMapper sysPermissionMapper;
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	@Autowired
	private SysRolePermissionMapper sysRolePermissionMapper;

	@RequestMapping(value = "/Test", method = RequestMethod.GET)
	public String getTest() {
		return "test";
	}

	@Override
	@RequestMapping(value="/getSysUserByName",method=RequestMethod.POST)
	public SysUser getSysUserByName(String username) {
		return sysUserMapper.selectOne(new QueryWrapper<SysUser>().eq("username", username));
	}

	@Override
	@RequestMapping(value="/findMenuListByUserId",method=RequestMethod.POST)
	public List<SysPermission> findMenuListByUserId(String userId) {
		List<SysPermission> permissions = new ArrayList<SysPermission>();
		SysUserRole sur = sysUserRoleMapper.selectOne(new QueryWrapper<SysUserRole>().eq("sys_user_id", userId));
		SysRolePermission srp = null;
		if (sur != null)
			srp = sysRolePermissionMapper
					.selectOne(new QueryWrapper<SysRolePermission>().eq("sys_role_id", sur.getSysRoleId()));

		String permission = null;
		if (srp != null)
			permission = srp.getSysPermissionId();
		SysPermission sp = null;
		if (permission != null)
			for (String id : permission.split(",")) {
				sp = sysPermissionMapper.selectOne(new QueryWrapper<SysPermission>().eq("id", id).eq("TYPE", "menu"));
				if (sp != null)
					permissions.add(sp);
			}
		return permissions;
	}

	@Override
	@RequestMapping(value="/findPermissionListByUserId",method=RequestMethod.POST)
	public List<SysPermission> findPermissionListByUserId(String userId) {
		List<SysPermission> permissions = new ArrayList<SysPermission>();
		SysUserRole sur = sysUserRoleMapper.selectOne(new QueryWrapper<SysUserRole>().eq("sys_user_id", userId));
		SysRolePermission srp = null;
		if (sur != null)
			srp = sysRolePermissionMapper
					.selectOne(new QueryWrapper<SysRolePermission>().eq("sys_role_id", sur.getSysRoleId()));

		String permission = null;
		if (srp != null)
			permission = srp.getSysPermissionId();
		SysPermission sp = null;
		if (permission != null)
			for (String id : permission.split(",")) {
				sp = sysPermissionMapper.selectOne(new QueryWrapper<SysPermission>().eq("id", id).eq("TYPE", "menu"));
				if (sp != null)
					permissions.add(sp);
			}
		return permissions;
	}
}
