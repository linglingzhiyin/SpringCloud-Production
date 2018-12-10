package com.mzj.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mzj.api.entity.authority.SysUser;
import com.mzj.api.service.ILoginService;
import com.mzj.mapper.SysUserMapper;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginService implements ILoginService {
	@Autowired
	private SysUserMapper sysUserMapper;

	@Value("${server.port}")
	private String serverPort;

	@RequestMapping(value = "/index")
	@ResponseBody
	public String index132() {
		return "sysService";
	}

	public SysUser login(@RequestParam("username") String username, @RequestParam("password") String password)
			throws Exception {
		return sysUserMapper.selectOne(new QueryWrapper<SysUser>().eq("username", username).eq("password", password));
	
	
	}

	static int i = 0;

	public String index(@RequestParam("abc") String abc) {

		System.out.println(serverPort + "/" + abc + i++);
		return serverPort + "/" + abc;
	}

	public String main() {
		return "main";
	}

	public String bug() {
		return "403";
	}
}
