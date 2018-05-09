package com.tuyano.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping("/page1")
	public ModelAndView page1(ModelAndView mav) {
		mav.setViewName("page1");
		return mav;
	}

	@RequestMapping("/page2")
	public ModelAndView page2(@RequestParam("name") String name, ModelAndView mav) {
		mav.setViewName("page2");
		mav.addObject("message", "Welcome " + name + " !!!");
		return mav;
	}
}
