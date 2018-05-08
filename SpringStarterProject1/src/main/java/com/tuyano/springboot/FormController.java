package com.tuyano.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
	@RequestMapping(value="/3/form", method=RequestMethod.GET)
	public ModelAndView doGet(ModelAndView mav) {
		mav.setViewName("page3");
		mav.addObject("msg", "フォームを入力して送信してください！");
		return mav;
	}

	@RequestMapping(value="/3/form", method=RequestMethod.POST)
	public ModelAndView doPost(
			@RequestParam(value="name", required=false)		String name,
			@RequestParam(value="gender", required=false)	String gender,
			@RequestParam(value="adult", required=false)	boolean adult,
			ModelAndView mav) {

		mav.addObject("msg",
				"Name: " + name + "\n" +
				"性別: " + gender + "\n" +
				"成人？: " + adult);

		mav.setViewName("page3");
		return mav;
	}
}
