package com.tuyano.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringContoller {

	@RequestMapping("/")
	public String root() {
		return "index";
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}
}
