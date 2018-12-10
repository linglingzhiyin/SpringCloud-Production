package com.mzj.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mzj.api.entity.authority.SysRolePermission;
import com.mzj.api.service.IPermissionService;
import com.mzj.mapper.SysPermissionMapper;
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
		return sysRolePermissionMapper.selectOne(new QueryWrapper<SysRolePermission>().eq("id", id));
	}

	@Override
	@RequestMapping(value = "/getRolePermissionByRoleId", method = RequestMethod.POST)
	public SysRolePermission getRolePermissionByRoleId(String roleId) {
		return sysRolePermissionMapper.selectOne(new QueryWrapper<SysRolePermission>().eq("sys_role_id", roleId));
	}

	@Override
	public boolean checkPermission(String username, String password,String url) {
		// 返回json数据
		return false;
	}

}
