package com.examples.example3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.examples.example3.dao.AlienRepo;
import com.examples.example3.models.Alien;

//@Controller
@RestController
public class AlienController {

	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/") //Defaults to @GetMapping
	public ModelAndView home()
	{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("home");
		
		return mv;
	}	

	@RequestMapping(path="/aliens"/*, produces = {"application/xml","application/json"}*/)
	//@ResponseBody //Needed only if using tag @Controller
	public List<Alien> getAliensData()
	{
		return repo.findAll();
	}

	@GetMapping("/alien/{aid}")
	//@ResponseBody
	public Optional<Alien> getAlienData(@PathVariable("aid") int aid)
	{
		return repo.findById(aid);
	}

	@PostMapping(path="/alien",consumes = {"application/json"})
	public Alien addAlien(@RequestBody Alien alien) //Request body here consumes raw data in Postman
	{
		repo.save(alien);
		return alien;
	}

	@DeleteMapping("/alien/{aid}")
	public String deleteAlien(@PathVariable("aid") int aid)
	{
		Alien a = repo.getOne(aid);
		repo.delete(a);
			
		return "deleted";
	}
	
	@PutMapping(path="/alien",consumes = {"application/json"})
	public Alien addORUpdateAlien(@RequestBody Alien alien) 
	{
		repo.save(alien);
		return alien;
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
	public ModelAndView addNewAlien(Alien alien)
	{
		repo.save(alien);
		
		ModelAndView mv = new ModelAndView("home");
				
		return mv;
	}

	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid)
	{
		ModelAndView mv = new ModelAndView("welcome");
		
		Alien alien = repo.findById(aid).orElse(new Alien());

		mv.addObject("alien",alien);
		
		return mv;
	}
}
