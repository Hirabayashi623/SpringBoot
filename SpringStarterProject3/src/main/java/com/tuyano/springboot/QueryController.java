package com.tuyano.springboot;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tuyano.springboot.repositories.MyDataRepository;

@Controller
public class QueryController {
	@Autowired
	MyDataRepository repository;

	@RequestMapping("/")
	public ModelAndView root(ModelAndView mav) {
		// 遷移先を指定
		mav.setViewName("index");
		mav.addObject("title", "INDEX");
		return mav;
	}

	@RequestMapping("/select")
	public ModelAndView select(ModelAndView mav) {
		// DB検索 全件取得
		Iterable<MyData> list = repository.findAll();
		mav.addObject("list", list);
		// 遷移先を指定
		mav.setViewName("select");
		mav.addObject("title", "選択");
		return mav;
	}

	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public ModelAndView insert(ModelAndView mav) {
		mav.setViewName("insert");
		mav.addObject("formModel", new MyData());
		return mav;
	}

	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView insert(@ModelAttribute("formModel") MyData mydata, ModelAndView mav) {
		repository.saveAndFlush(mydata);
		return mav;
	}

	@RequestMapping(value="/update", method=RequestMethod.GET)
	public ModelAndView update(ModelAndView mav) {
		mav.setViewName("update");
		Iterable<MyData> list = repository.findAll();
		mav.addObject("list", list);
		return mav;
	}

	@RequestMapping(value="/complete", method=RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView update(@ModelAttribute("data") MyData data, ModelAndView mav) {
		System.out.println(data);
		mav.setViewName("update");
		repository.saveAndFlush(data);

		Iterable<MyData> list = repository.findAll();
		mav.addObject("list", list);
		mav.addObject("message", "更新しました");
		return mav;
	}

	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam("id") int id, ModelAndView mav) {
		Optional<MyData> opt = repository.findById((long)id);
		MyData data = opt.orElseGet(() -> new MyData("unknown", 0));
		mav.addObject("data", data);
		mav.setViewName("edit");
		return mav;
	}

	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public ModelAndView delete(ModelAndView mav) {
		Iterable<MyData> list = repository.findAll();
		mav.addObject("list", list);
		mav.setViewName("delete");
		return mav;
	}

	@RequestMapping(value="/delete", method=RequestMethod.POST)
	@Transactional(readOnly = false)
	public ModelAndView delete(@RequestParam("id") int id, ModelAndView mav) {
		repository.deleteById((long)id);
		mav.addObject("messages", new String[] {"削除しました"});
		mav.setViewName("delete");
		return delete(mav);
	}

	@RequestMapping(value="/page")
	public ModelAndView page(ModelAndView mav, Pageable pageable) {
		System.out.println(pageable.getPageSize() + " " + pageable.getPageNumber());
		Page<MyData> list = repository.findAll(pageable);
		mav.addObject("list", list);
		mav.setViewName("select");
		return delete(mav);
	}

	@PostConstruct
	public void init() {
		repository.saveAndFlush(new MyData("ryo", 24));
		repository.saveAndFlush(new MyData("emi", 25));
		repository.saveAndFlush(new MyData("ryo", 24));
		repository.saveAndFlush(new MyData("emi", 25));
		repository.saveAndFlush(new MyData("ryo", 24));
		repository.saveAndFlush(new MyData("emi", 25));
		repository.saveAndFlush(new MyData("ryo", 24));
		repository.saveAndFlush(new MyData("emi", 25));
		repository.saveAndFlush(new MyData("ryo", 24));
		repository.saveAndFlush(new MyData("emi", 25));
	}
}
