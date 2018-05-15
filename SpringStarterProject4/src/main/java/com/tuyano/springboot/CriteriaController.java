package com.tuyano.springboot;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CriteriaController {
	CriteriaSampleDAO dao;

	@PersistenceContext
	EntityManager manager;

	@PostConstruct
	public void init() {
		dao = new CriteriaSampleDAO(manager);
	}

	@RequestMapping("/criteria")
	public String index() {
		return "criteriaAPI";
	}

	@RequestMapping("/criteria/getAll")
	public ModelAndView getAll(ModelAndView mav) {
		List<UserBean> samples = dao.getAll();
		mav.addObject("samples", samples);
		mav.setViewName("criteriaAPI1");
		return mav;
	}

	@RequestMapping(value="/criteria/nameSerch", method=RequestMethod.GET)
	public ModelAndView nameSerch(ModelAndView mav) {
		mav.setViewName("criteriaAPI2");
		return mav;
	}

	@RequestMapping(value="/criteria/nameSerch", method=RequestMethod.POST)
	public ModelAndView nameSerch(@RequestParam("name") String name, ModelAndView mav) {
		List<UserBean> samples = dao.nameSerch(name);
		mav.addObject("samples", samples);
		mav.setViewName("criteriaAPI2");
		return mav;
	}

	@RequestMapping("/criteria/orderByDesc")
	public ModelAndView orderByDesc(ModelAndView mav) {
		List<UserBean> samples = dao.orderByDesc();
		mav.addObject("samples", samples);
		mav.setViewName("criteriaAPI1");
		return mav;
	}

	@RequestMapping(value="/criteria/limit", method=RequestMethod.POST)
	public ModelAndView limit(
			@RequestParam("first") int first
			, @RequestParam("count") int count
			, ModelAndView mav) {
		System.out.println(first + " " + count);
		List<UserBean> samples = dao.limit(first, count);
		mav.addObject("samples", samples);
		mav.setViewName("criteriaAPI3");
		return mav;
	}

	@RequestMapping(value="/criteria/limit", method=RequestMethod.GET)
	public ModelAndView limit(ModelAndView mav) {
		mav.setViewName("criteriaAPI3");
		return mav;
	}
}
