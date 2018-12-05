package com.mzj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import com.mzj.api.entity.authority.SysUser;
import com.mzj.api.service.IUserService;
import com.mzj.mapper.SysUserMapper;

@RestController
@RequestMapping("/UserService")
public class UserService implements IUserService {

	@Autowired
	SysUserMapper sysUserMapper;

	@RequestMapping(value = "/UserServiceTest", method = RequestMethod.GET)
	public String getTest() {
		return "test";
	}

	@RequestMapping("/getUser")
	public SysUser getUser(String id) {
		SysUser s = new SysUser();
		s.setId(id);
		return sysUserMapper.selectOne(s);
	}

	@Override	
	@RequestMapping(value="/findByUserNameAndId",method=RequestMethod.POST)
	public List<SysUser> findByUserNameAndId(String username, String id) {
		if (id != null)
			return sysUserMapper.selectList(new EntityWrapper<SysUser>().eq("username", username).ne("id", id));
		return null;
	}

	@Override
	@RequestMapping(value="/searchSysUserBySysUserName",method=RequestMethod.POST)
	public List<SysUser> searchSysUserBySysUserName(String sysUserName) {
		return sysUserMapper.selectList(new EntityWrapper<SysUser>().like("username", sysUserName));
	}

	@Override
	@RequestMapping(value="/searchSysUserBySysUserId",method=RequestMethod.POST)
	public List<SysUser> searchSysUserBySysUserId(String sysUserId) {
		return sysUserMapper.selectList(new EntityWrapper<SysUser>().like("id", sysUserId));
	}

}
