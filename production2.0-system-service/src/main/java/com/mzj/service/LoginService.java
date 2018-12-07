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
	

	public Map<String, Object> login(@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam(value = "randomcode", required = false) String randomcode, HttpSession session)
			throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();

		if (randomcode != null && !randomcode.equals("")) {
			// 取出session的验证码（正确的验证码）
			String validateCode = (String) session.getAttribute("validateCode");
			// 页面中输入的验证和session中的验证进行对比
			if (validateCode != null && !randomcode.equals(validateCode)) {
				// 如果校验失败，将验证码错误失败信息放入map中
				map.put("msg", "randomcode_error");
				// 直接返回，不再校验账号和密码
				return map;
			}
		}
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
