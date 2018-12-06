package com.mzj.controllor;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ThymeleafController {

	@RequestMapping("/index")
	public String index(Map<String, Object> map) {
		map.put("user", "Tyrone");
		return "index";
	}

}