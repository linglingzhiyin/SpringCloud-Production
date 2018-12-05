package com.mzj.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mzj.api.entity.authority.SysRole;
import com.mzj.api.entity.authority.SysUser;
import com.mzj.api.entity.authority.SysUserRole;
import com.mzj.api.entity.vo.RoleVO;
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
		List<SysUserRole> list = sysUserRoleMapper.selectList(new EntityWrapper<SysUserRole>().eq("sysuserid", userId));
		if (!CollectionUtils.isEmpty(list)) {
			for (SysUserRole sr : list) {
				SysRole r = new SysRole();
				r.setRoleId(sr.getSysRoleId());
				roles.add(sysRoleMapper.selectOne(r));
			}
			return roles;
		}
		return null;
	}

	@Override
	@RequestMapping(value = "/findByRoleNameAndId", method = RequestMethod.POST)
	public List<SysRole> findByRoleNameAndId(String rolename, String id) {
		if (id != null)
			return sysRoleMapper.selectList(new EntityWrapper<SysRole>().eq("rolename", rolename).ne("id", id));
		return null;

	}

	@Override
	@RequestMapping(value = "/findRoleByUserId", method = RequestMethod.POST)
	public List<SysRole> searchSysRoleBySysRoleName(String sysRoleName) {
		return sysRoleMapper.selectList(new EntityWrapper<SysRole>().like("rolename", sysRoleName));
	}

	@Override
	@RequestMapping(value = "/searchSysRoleBySysRoleId", method = RequestMethod.POST)
	public List<SysRole> searchSysRoleBySysRoleId(String sysRoleId) {
		return sysRoleMapper.selectList(new EntityWrapper<SysRole>().like("id", sysRoleId));
	}

}
