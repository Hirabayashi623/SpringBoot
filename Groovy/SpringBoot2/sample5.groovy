@Grab("thymeleaf-spring5")

@Controller
class App{
	@RequestMapping("/sample5")
	@ResponseBody
	def sample3(ModelAndView mav){
		mav.setViewName("sample5")
		mav
	}

	@RequestMapping("/sample5/submit")
	@ResponseBody
	def sample3(@RequestParam("item")String str, ModelAndView mav){
		mav.setViewName("sample5")
		mav.addObject("items", "<li>" + str + "</li>")
		mav
	}

}