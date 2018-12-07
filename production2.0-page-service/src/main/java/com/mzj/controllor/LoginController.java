package com.mzj.controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mzj.feign.LoginService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
	static int i = 0;
	@Autowired
	private LoginService loginService;

	/**
	 * ajax登录
	 */
	@RequestMapping(value = "/ajaxLogin")
	@ResponseBody
	@HystrixCommand(fallbackMethod = "indexHystrixfallbackMethod")
	public Map<String, Object> ajaxLogin(@RequestParam String username, @RequestParam String password,
			@RequestParam(required = false) String randomcode, HttpSession session) throws Exception {
		return loginService.login(username, password, randomcode, session);
	}

	@RequestMapping(value = "/index123456")
	@ResponseBody
	public String index(@RequestParam String username) throws Exception {
		return loginService.index(username);
	}

	@RequestMapping(value = "/indexHystrix")
	@ResponseBody
	@HystrixCommand(fallbackMethod = "indexHystrixfallbackMethod")
	public String indexHystrix() {
		System.out.println(Thread.currentThread().getName()+"abc"+i++);
		
		return "abc";
	}

	public String indexHystrixfallbackMethod() {
		System.out.println("test");
		return "test";
	}
}
