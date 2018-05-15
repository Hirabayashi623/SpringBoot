package com.tuyano.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestController {
	@Autowired
	private SampleDataService service;

	@RequestMapping("/service/rest")
	public List<UserBean> getAll() {
		return service.getAll();
	}

//	@RequestMapping("/service/xml")
//	public List<UserXmlBean> xml() {
//		return service.getXml();
//	}

}
