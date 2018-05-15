package com.tuyano.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {
	@Autowired
	private SampleDataService service;

	@RequestMapping("/service")
	public String index() {
		return "service";
	}

	@RequestMapping("/service/getAll")
	public ModelAndView getAll(ModelAndView mav) {
		List<UserBean> users =  service.getAll();
		mav.addObject("users", users);
		mav.setViewName("service1");
		return mav;
	}

	@RequestMapping("/service/ajax")
	public String ajax() {
		return "ajax/service2";
	}
}
