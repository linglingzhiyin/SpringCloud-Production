package com.mzj.api.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/")
public interface IRegisterService {
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public String register(String username, String password, String phone, String email);
}
