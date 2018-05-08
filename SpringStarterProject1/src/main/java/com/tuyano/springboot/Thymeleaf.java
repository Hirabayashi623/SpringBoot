package com.tuyano.springboot;


import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Thymeleaf {
	@RequestMapping("/4")
	public String execute() {
		return "page4";
	}

	@RequestMapping("/5")
	public String page5(Model model) {
		Object obj = new Object() {
			public String getName() {
				return "ryo";
			}
			public int getId() {
				return 1;
			}
		};

		model.addAttribute("html", "this is <strong>strong</strong> context.");
		model.addAttribute("obj", obj);
		return "page5";
	}

	@RequestMapping("/6")
	public String page6default() {
		return "redirect:/6/1";
	}

	@RequestMapping("/6/{num}")
	public ModelAndView page6(@PathVariable int num, ModelAndView mav) {
		mav.setViewName("page6");
		mav.addObject("trueMsg", "this is even number !");
		mav.addObject("falseMsg", "this is odd number...");
		mav.addObject("isEven", num % 2 == 0);
		mav.addObject("isEvenNum", num % 2);

		mav.addObject("families", Arrays.asList(new Object[] {
				new String[] {"1", "ryo"},
				new String[] {"2", "emi"},
				new String[] {"3", "ru-"}
		}));

		mav.addObject("rcvNum", "" + num);
		return mav;
	}

	@RequestMapping("/7")
	public String page7() {
		return "page7";
	}
}
