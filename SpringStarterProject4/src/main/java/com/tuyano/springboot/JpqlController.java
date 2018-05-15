package com.tuyano.springboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tuyano.springboot.repositories.SampleRepository;

@Controller
public class JpqlController {
	@Autowired
	SampleRepository repository;

	@RequestMapping("/jpql")
	public String index() {
		return "jpql";
	}

	@RequestMapping("/jpql/and")
	public ModelAndView and(ModelAndView mav) {
		List<UserBean> samples = repository.findByIdAndName(1, "user1");
		mav.addObject("samples", samples);
		mav.setViewName("jpql_sample1");
		return mav;
	}

	@RequestMapping("/jpql/all")
	public ModelAndView all(ModelAndView mav) {
		List<UserBean> samples = repository.findAll();
		mav.addObject("samples", samples);
		mav.setViewName("jpql_sample1");
		return mav;
	}

	@RequestMapping("/jpql/or")
	public ModelAndView or(ModelAndView mav) {
		List<UserBean> samples = repository.findByIdOrId(1L, 2L);
		mav.addObject("samples", samples);
		mav.setViewName("jpql_sample1");
		return mav;
	}

	@RequestMapping("/jpql/between")
	public ModelAndView between(ModelAndView mav) {
		List<UserBean> samples = repository.findByIdBetween(1L, 5L);
		mav.addObject("samples", samples);
		mav.setViewName("jpql_sample1");
		return mav;
	}

	@RequestMapping("/jpql/lessthan")
	public ModelAndView lessthan(ModelAndView mav) {
		List<UserBean> samples = repository.findByIdLessThan(5L);
		mav.addObject("samples", samples);
		mav.setViewName("jpql_sample1");
		return mav;
	}

	@RequestMapping("/jpql/greaterthan")
	public ModelAndView greaterthan(ModelAndView mav) {
		List<UserBean> samples = repository.findByIdGreaterThan(5L);
		mav.addObject("samples", samples);
		mav.setViewName("jpql_sample1");
		return mav;
	}

	@RequestMapping("/jpql/like")
	public ModelAndView like(ModelAndView mav) {
		List<UserBean> samples = repository.findByNameLike("user%");
		mav.addObject("samples", samples);
		mav.setViewName("jpql_sample1");
		return mav;
	}

	@RequestMapping("/jpql/desc")
	public ModelAndView desc(ModelAndView mav) {
		List<UserBean> samples = repository.findByNameLikeOrderByIdDesc("user%");
		mav.addObject("samples", samples);
		mav.setViewName("jpql_sample1");
		return mav;
	}

	@RequestMapping("/jpql/not")
	public ModelAndView not(ModelAndView mav) {
		List<UserBean> samples = repository.findByIdNot(3L);
		mav.addObject("samples", samples);
		mav.setViewName("jpql_sample1");
		return mav;
	}

	@RequestMapping("/jpql/in")
	public ModelAndView in(ModelAndView mav) {
		List<Long> id = Arrays.asList(new Long[] {1L,3L,6L});
		List<UserBean> samples = repository.findByIdIn(id);
		mav.addObject("samples", samples);
		mav.setViewName("jpql_sample1");
		return mav;
	}

	@RequestMapping("/dao/query")
	public ModelAndView query(ModelAndView mav) {
		List<UserBean> samples = repository.query();
		mav.addObject("samples", samples);
		mav.setViewName("dao_part");
		return mav;
	}

	@RequestMapping(value="/dao/queryBind", method=RequestMethod.POST)
	public ModelAndView queryBind(@RequestParam("id") long id, ModelAndView mav) {
		List<UserBean> samples = repository.queryBind(id);
		mav.addObject("samples", samples);
		mav.setViewName("dao_part1");
		return mav;
	}

	@RequestMapping(value="/dao/queryBind", method=RequestMethod.GET)
	public ModelAndView queryBind(ModelAndView mav) {
		mav.setViewName("dao_part1");
		return mav;
	}
}
