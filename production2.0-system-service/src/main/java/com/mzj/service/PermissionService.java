package com.mzj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mzj.api.entity.authority.SysRolePermission;
import com.mzj.api.service.IPermissionService;
import com.mzj.mapper.SysPermissionMapper;
import com.mzj.mapper.SysRoleMapper;
import com.mzj.mapper.SysRolePermissionMapper;

@RestController
@RequestMapping("/PermissionService")
public class PermissionService implements IPermissionService {

	@Autowired
	private SysPermissionMapper sysPermissionMapper;
	@Autowired
	private SysRolePermissionMapper sysRolePermissionMapper;

	@RequestMapping(value = "/Test", method = RequestMethod.GET)
	public String getTest() {
		return "test";
	}

	@Override
	@RequestMapping(value = "/findByUserNameAndId", method = RequestMethod.POST)
	public List<SysRolePermission> findAll() {
		return sysRolePermissionMapper.selectList(null);
	}

	@Override
	@RequestMapping(value = "/getRolePermissionById", method = RequestMethod.POST)
	public SysRolePermission getRolePermissionById(String id) {
		SysRolePermission sysRolePermission = new SysRolePermission();
		sysRolePermission.setId(id);
		return sysRolePermissionMapper.selectOne(sysRolePermission);
	}

	@Override
	@RequestMapping(value = "/getRolePermissionByRoleId", method = RequestMethod.POST)
	public SysRolePermission getRolePermissionByRoleId(String roleId) {
		SysRolePermission sysRolePermission = new SysRolePermission();
		sysRolePermission.setSysRoleId(roleId);
		return sysRolePermissionMapper.selectOne(sysRolePermission);
	}

}
