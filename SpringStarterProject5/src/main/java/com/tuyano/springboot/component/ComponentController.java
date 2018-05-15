package com.tuyano.springboot.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ComponentController {
	@Autowired
	SampleComponent component;

	@Autowired
	SampleBean bean;

	@RequestMapping("/component")
	public String index() {
		return "component";
	}

	@RequestMapping("/component/count")
	public ModelAndView count(ModelAndView mav) {
		mav.addObject("count", component.count());
		mav.setViewName("component/count");
		return mav;
	}

	@RequestMapping("/component/config")
	public ModelAndView config(ModelAndView mav) {
		mav.addObject("count", bean.count());
		mav.setViewName("component/count");
		return mav;
	}
}
