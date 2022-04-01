package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Headphone;
import dmacc.repository.HeadphoneRepository;

@Controller
public class WebController {
	@Autowired
	HeadphoneRepository repo;
	
	@GetMapping("/viewAll")
	public String viewAllHeadphones(Model model) {
		model.addAttribute("headphones", repo.findAll());
		return "results";
	}
	
	@GetMapping("/inputHeadphone")
	public String addNewHeadphone(Model model) {
		Headphone h = new Headphone();
		model.addAttribute("newHeadphone", h);
		return "input";
	}
	
	@PostMapping("/inputHeadphone")
	public String addNewHeadphone(@ModelAttribute Headphone h, Model model) {
		repo.save(h);
		return viewAllHeadphones(model);
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateHeadphone(@PathVariable("id") long id, Model model) {
		Headphone h = repo.findById(id).orElse(null);
		model.addAttribute("newHeadphone", h);
		return "input";
	}
	
	@PostMapping("/update/{id}")
	public String reviseHeadphone(Headphone h, Model model) {
		repo.save(h);
		return viewAllHeadphones(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id")long id, Model model) {
		Headphone h = repo.findById(id).orElse(null);
		repo.delete(h);
		return viewAllHeadphones(model);
	}

}
