package com.mzj.controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mzj.feign.LoginService;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;

	/**
	 * ajax登录
	 */
	@RequestMapping(value = "/ajaxLogin")
	@ResponseBody
	public Map<String, Object> ajaxLogin(@RequestParam String username, @RequestParam String password,
			@RequestParam(required = false) String randomcode, HttpSession session) throws Exception {
		return loginService.login(username, password, randomcode, session);
	}
}
