package com.tuyano.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tuyano.springboot.repositories.SampleRepository;

@Controller
public class SampleController {
	@Autowired
	SampleRepository repository;

	@RequestMapping("/sample")
	public ModelAndView sample(ModelAndView mav) {
		Iterable<UserBean> samples = repository.findAll();
		mav.addObject("samples", samples);
		mav.setViewName("sample");
		return mav;
	}

	@RequestMapping("/")
	public String root() {
		return "index";
	}
}
