package com.mzj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mzj.api.entity.authority.SysRole;
import com.mzj.api.entity.authority.SysUserRole;
import com.mzj.api.service.IRoleService;
import com.mzj.mapper.SysRoleMapper;
import com.mzj.mapper.SysUserRoleMapper;

@RestController
@RequestMapping("/RoleService")
public class RoleService implements IRoleService {

	@Autowired
	private SysRoleMapper sysRoleMapper;

	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;

	@RequestMapping(value = "/Test", method = RequestMethod.GET)
	public String getTest() {
		return "test";
	}

	@Override
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<SysRole> findAll() {
		return sysRoleMapper.selectList(null);
	}

	@Override
	@RequestMapping(value = "/findRoleByUserId", method = RequestMethod.POST)
	public List<SysRole> findRoleByUserId(String userId) {
		List<SysRole> roles = new ArrayList<SysRole>();
		List<SysUserRole> list = sysUserRoleMapper.selectList(new QueryWrapper<SysUserRole>().eq("sys_user_id", userId));
		if (!CollectionUtils.isEmpty(list)) {
			for (SysUserRole sur : list) {
				SysRole sr=sysRoleMapper.selectOne(new QueryWrapper<SysRole>().eq("role_id", sur.getSysRoleId()));
				roles.add(sr);
			}
			return roles;
		}
		return null;
	}

	@Override
	@RequestMapping(value = "/findByRoleNameAndId", method = RequestMethod.POST)
	public List<SysRole> findByRoleNameAndId(String rolename, String id) {
		if (id != null)
			return sysRoleMapper.selectList(new QueryWrapper<SysRole>().eq("role_name", rolename).ne("id", id));
		return null;

	}

	@Override
	@RequestMapping(value = "/searchSysRoleBySysRoleName", method = RequestMethod.POST)
	public List<SysRole> searchSysRoleBySysRoleName(String sysRoleName) {
		return sysRoleMapper.selectList(new QueryWrapper<SysRole>().like("role_name", sysRoleName));
	}

	@Override
	@RequestMapping(value = "/searchSysRoleBySysRoleId", method = RequestMethod.POST)
	public List<SysRole> searchSysRoleBySysRoleId(String sysRoleId) {
		return sysRoleMapper.selectList(new QueryWrapper<SysRole>().like("role_id", sysRoleId));
	}

}
