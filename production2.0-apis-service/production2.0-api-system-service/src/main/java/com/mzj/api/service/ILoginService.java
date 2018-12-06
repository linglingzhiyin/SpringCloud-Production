package com.mzj.api.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;

public interface ILoginService {
	
	public Map<String, Object> login(@RequestParam String username, @RequestParam String password,
			@RequestParam(required = false) String randomcode, HttpSession session) throws Exception;

	public String index();

	public String main();

	public String bug();
}
