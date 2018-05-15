package com.tuyano.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ValidateController {
	@RequestMapping(value="/validate", method=RequestMethod.GET)
	public ModelAndView validate(ModelAndView mav) {
		mav.addObject("target", new ValidateTarget());
		mav.setViewName("validate");
		return mav;
	}

	@RequestMapping(value="/validate", method=RequestMethod.POST)
	public ModelAndView validate(@ModelAttribute("target") @Validated ValidateTarget target
									,BindingResult result
									,ModelAndView mav) {
		if(!result.hasErrors()) {
			mav.addObject("result", "検証結果：ＯＫ");
		}else {
			mav.addObject("result", "検証結果：ＮＧ");
		}
		return mav;
	}
}
