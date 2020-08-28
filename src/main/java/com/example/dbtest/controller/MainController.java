package com.example.dbtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.dbtest.entity.Idol;
import com.example.dbtest.repository.IdolRepository;

@Controller
public class MainController {
	@Autowired
	IdolRepository repository;

	@RequestMapping("/")
	private ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		Iterable<Idol> list = repository.findAll();
		mav.addObject("data", list);
		return mav;
	}

	@RequestMapping("/insert")
	@Transactional(readOnly = false)
	private ModelAndView insert(@ModelAttribute("formInsert") Idol idol, ModelAndView mav) {
		repository.saveAndFlush(idol);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping("/update")
	@Transactional(readOnly = false)
	private ModelAndView update(@ModelAttribute("formUpdate") Idol idol, ModelAndView mav) {
		repository.saveAndFlush(idol);
		return new ModelAndView("redirect:/");
	}
	@RequestMapping("/delete")
	@Transactional(readOnly = false)
	private ModelAndView delete(@ModelAttribute("formDelete") Idol idol, ModelAndView mav) {
		repository.delete(idol);
		return new ModelAndView("redirect:/");
	}
	
}