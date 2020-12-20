package com.examples.example3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.examples.example3.dao.AlienRepo;
import com.examples.example3.models.Alien;

@Controller
public class AlienController {

	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public ModelAndView home()
	{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("home");
		
		return mv;
	}	

	@RequestMapping("/processAlien")
	public String process()
	{
		System.out.println(repo.findByAidLessThan(8));
		System.out.println(repo.findByTech("java"));
		System.out.println(repo.findByTechSorted("java"));
		System.out.println(repo.findByNameAndTech("purvang", "java"));
		
		return "home";
	}
	
	@RequestMapping("/addAlien")
	public ModelAndView addAlien(Alien alien)
	{
		repo.save(alien);
		
		ModelAndView mv = new ModelAndView("home");
				
		return mv;
	}

	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam("aid") int aid)
	{
		ModelAndView mv = new ModelAndView("welcome");
		
		Alien alien = repo.findById(aid).orElse(new Alien());

		mv.addObject("alien",alien);
		
		return mv;
	}
}
