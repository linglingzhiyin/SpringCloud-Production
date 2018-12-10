package com.mzj.api.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mzj.api.entity.authority.SysUser;

@RequestMapping("/")
public interface ILoginService {

	@RequestMapping(value = "/login")
	@ResponseBody
	public SysUser login(@RequestParam("username") String username,
			@RequestParam("password") String password)
			throws Exception;

	@RequestMapping("/index123")
	public String index(@RequestParam("abc") String abc);

	@RequestMapping("/main")
	public String main();

	@RequestMapping("/bug")
	public String bug();
}
