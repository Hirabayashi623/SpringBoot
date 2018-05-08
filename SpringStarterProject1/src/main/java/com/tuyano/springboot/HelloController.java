package com.tuyano.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/2")
	public String index() {
		return "index";
	}

	@RequestMapping("/2/model/{str}")
	public String useModel(@PathVariable String str, Model model) {
		model.addAttribute("msg", "recept string is : " + str);
		return "page1";
	}

	@RequestMapping("/2/mav/{str}")
	public ModelAndView useModelAndView(@PathVariable String str, ModelAndView mav) {
		String msg = "recept string is " + str;
		mav.addObject("msg", msg);
		mav.setViewName("page1");
		return mav;
	}

	@RequestMapping(value="/2/form", method=RequestMethod.POST)
	public ModelAndView useFormRcv(@RequestParam("name") String name, ModelAndView mav) {
		mav.addObject("msg", "Hello, " + name + " !!!");
		mav.addObject("value", name);
		mav.setViewName("page2");

		return mav;
	}

	@RequestMapping(value="/2/form", method=RequestMethod.GET)
	public ModelAndView useFormSnd(ModelAndView mav) {
		mav.addObject("msg", "What's your name ?");
		mav.setViewName("page2");
		return mav;
	}
}
