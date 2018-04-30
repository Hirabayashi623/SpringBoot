@RestController
class App{
	@RequestMapping("/sample2")
	def query(){
		def header = "<html><body>"
		def footer = "</body></html>"
		def content = "<h1>Hello World !!!</h1><p>this is html content</p>"
	}
}