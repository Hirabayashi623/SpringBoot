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
public class DAOController {
	@PersistenceContext
	EntityManager manager;

	SampleDAO dao;

	@PostConstruct
	public void init() {
		dao = new SampleDAO(manager);
	}

	@RequestMapping("/dao")
	public ModelAndView index(ModelAndView mav) {
		List<UserBean> samples = dao.getAll();
		mav.addObject("samples", samples);
		mav.setViewName("dao");
		return mav;
	}

	@RequestMapping("/dao/getAll")
	public ModelAndView getAll(ModelAndView mav) {
		List<UserBean> samples = dao.getAll();
		mav.addObject("samples", samples);
		mav.setViewName("dao_part");
		return mav;
	}

	@RequestMapping(value="/dao/selectByPK", method=RequestMethod.POST)
	public ModelAndView selectByPK(@RequestParam("id") int id, ModelAndView mav) {
		List<UserBean> samples = dao.selectByPK(id);
		mav.addObject("samples", samples);
		mav.setViewName("dao_part1");
		return mav;
	}

	@RequestMapping(value="/dao/selectByPK", method=RequestMethod.GET)
	public ModelAndView selectByPK(ModelAndView mav) {
		mav.setViewName("dao_part1");
		return mav;
	}

	@RequestMapping(value="/dao/selectByPkUseBind", method=RequestMethod.POST)
	public ModelAndView selectByPkUseBind(@RequestParam("id") int id, ModelAndView mav) {
		List<UserBean> samples = dao.selectByPK(id);
		mav.addObject("samples", samples);
		mav.setViewName("dao_part1");
		return mav;
	}

	@RequestMapping(value="/dao/selectByPkUseBind", method=RequestMethod.GET)
	public ModelAndView selectByPkUseBind(ModelAndView mav) {
		mav.setViewName("dao_part1");
		return mav;
	}

	@RequestMapping(value="/dao/namedQuery", method=RequestMethod.POST)
	public ModelAndView namedQuery(@RequestParam("id") int id, ModelAndView mav) {
		List<UserBean> samples = dao.namedQuery(id);
		mav.addObject("samples", samples);
		mav.setViewName("dao_part1");
		return mav;
	}

	@RequestMapping(value="/dao/namedQuery", method=RequestMethod.GET)
	public ModelAndView namedQuery(ModelAndView mav) {
		mav.setViewName("dao_part1");
		return mav;
	}
}
