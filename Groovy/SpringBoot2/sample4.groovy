@Grab("thymeleaf-spring5")

@Controller
class App{
	@RequestMapping("/sample4")
	@ResponseBody
	def sample3(ModelAndView mav){
		mav.setViewName("sample4")
		mav.addObject("msg", "Tihs is groovy msg. ���܂��ϊ��ł������ȁH")
		mav
	}

}