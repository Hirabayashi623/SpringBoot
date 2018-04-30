@Grab("thymeleaf-spring5")

@Controller
class App{
	@RequestMapping("/sample3")
	@ResponseBody
	def sample3(ModelAndView mav){
		mav.setViewName("sample3")
		mav
	}

	@RequestMapping("/sample3/2")
	@ResponseBody
	def sample3_2(ModelAndView mav){
		mav.setViewName("sample3-2")
		mav
	}
}