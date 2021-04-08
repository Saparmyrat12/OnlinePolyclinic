package com.example.demo.controller;


import com.example.demo.entity.Speciality;
import com.example.demo.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/specialities")
public class SpecialityController {

	private SpecialityService specialityService;

	@Autowired
	public SpecialityController(SpecialityService theSpecialityService) {
		specialityService = theSpecialityService;
	}

	// list of specialities
	@GetMapping("/list")
	public String listSpecialities(Model theModel) {

		// get specialities from database
		List<Speciality> theSpecialities = specialityService.findAll();

		// add to the spring model
		theModel.addAttribute("specialities", theSpecialities);

		return "/specialities/list-specialities";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Speciality theSpeciality = new Speciality();

		theModel.addAttribute("speciality", theSpeciality);

		return "/specialities/speciality-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("specialityId") int theId, Model theModel) {

		// get the speciality from the service
		Speciality theSpeciality = specialityService.findById(theId);

		// set speciality as a model attribute to pre-populate the form
		theModel.addAttribute("speciality", theSpeciality);

		// send over to our form
		return "/specialities/speciality-form";
	}

	@PostMapping("/save")
	public String saveSpeciaity(@ModelAttribute("speciality") Speciality theSpeciality) {

		// save the speciality
		specialityService.save(theSpeciality);

		// use a redirect to prevent duplicate submissions
		return "redirect:/specialities/list";
	}

	@GetMapping("/delete")
	public String deleteSpeciality(@RequestParam("specialityId") int theId) {

		// delete the speciality
		specialityService.deleteById(theId);

		return "redirect:/specialities/list";
	}
}
