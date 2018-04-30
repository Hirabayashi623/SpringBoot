@Grab("thymeleaf-spring5")

@Controller
class App{
	@RequestMapping("/sample4")
	@ResponseBody
	def sample3(ModelAndView mav){
		mav.setViewName("sample4")
		mav.addObject("msg", "Tihs is groovy msg. Ç§Ç‹Ç≠ïœä∑Ç≈Ç´ÇΩÇ©Ç»ÅH")
		mav
	}

}