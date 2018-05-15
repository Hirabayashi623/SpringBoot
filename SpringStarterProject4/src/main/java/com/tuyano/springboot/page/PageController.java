package com.tuyano.springboot.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tuyano.springboot.UserBean;

@Controller
public class PageController {
	@Autowired
	PageRepository repository;

	@RequestMapping("/other")
	public String index() {
		return "other_idx";
	}

	@RequestMapping("/other/page")
	public ModelAndView page(ModelAndView mav, Pageable pageable) {
//		System.out.println(pageable.getPageSize() + " " + pageable.getPageNumber());
		Page<UserBean> samples = repository.findAll(pageable);
//		List<UserBean> samples = repository.findAll();
		mav.addObject("samples", samples);
		mav.setViewName("other/page");
		return mav;
	}
}
