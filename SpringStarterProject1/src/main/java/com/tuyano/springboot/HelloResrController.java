package com.tuyano.springboot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResrController {
	@RequestMapping("/")
	public String index() {
		return "Hello Spring-Boot World !!!";
	}

	@RequestMapping("/1/num/{num}")
	public String index(@PathVariable int num) {
		return "num = " + num;
	}

	@RequestMapping("/1/num/{n1}/{n2}")
	public String index(@PathVariable int n1, @PathVariable int n2) {
		return "num = " + n1 * n2;
	}

	@RequestMapping("/1/json")
	public Object json() {
		Object obj = new Object() {
			private String name = "ryo";
			private String company = "Yahoo";
			public String getName() {
				return this.name;
			}
			public String getCompany() {
				return this.company;
			}
		};

		return obj;
	}
}
