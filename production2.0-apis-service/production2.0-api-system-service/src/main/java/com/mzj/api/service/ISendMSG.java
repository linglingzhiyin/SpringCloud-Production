package com.mzj.api.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/")
public interface ISendMSG {
	@RequestMapping(value = "/sendMSG")
	@ResponseBody
	public String ISendMSG();
}
