package com.mzj.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mzj.api.service.ILoginService;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginService implements ILoginService {
	
	@Value("${server.port}")
	private String serverPort;

	@RequestMapping(value = "/index")
	@ResponseBody
	public String index132() {
		return "sysService";
	}

	public Map<String, Object> login(@RequestParam("username") String username,
			@RequestParam("password") String password)
			throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();

		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			try {
				currentUser.login(token);
			} catch (UnknownAccountException ex) {
				map.put("msg", "account_error");
			} catch (IncorrectCredentialsException ex) {
				map.put("msg", "password_error");
			} catch (AuthenticationException ex) {
				map.put("msg", "authentication_error");
			}
		}
		// 返回json数据
		return map;
	}
	
	static int i=0;
	public String index(@RequestParam("abc") String abc) {
		
		System.out.println(serverPort+"/"+abc+i++);
		return serverPort+"/"+abc;
	}

	public String main() {
		return "main";
	}

	public String bug() {
		return "403";
	}
}
