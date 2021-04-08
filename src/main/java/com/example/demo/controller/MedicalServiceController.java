package com.example.demo.controller;


import com.example.demo.entity.MedicalService;
import com.example.demo.service.MedicalServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/medical-services")
public class MedicalServiceController {

	private MedicalServiceService medicalServiceService;

	@Autowired
	public MedicalServiceController(MedicalServiceService theMedicalServiceService) {
		medicalServiceService = theMedicalServiceService;
	}

	// list of medical services
	@GetMapping("/list")
	public String listSpecialities(Model theModel) {

		// get medical services from database
		List<MedicalService> theMedicalServices = medicalServiceService.findAll();

		// add to the spring model
		theModel.addAttribute("medicalServices", theMedicalServices);

		return "/medical-services/list-medical-services";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		MedicalService theMedicalService = new MedicalService();

		theModel.addAttribute("medicalService", theMedicalService);

		return "/medical-services/medical-service-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("medicalServiceId") int theId, Model theModel) {

		// get the medical service from the service
		MedicalService theMedicalService = medicalServiceService.findById(theId);

		// set medical service as a model attribute to pre-populate the form
		theModel.addAttribute("medicalService", theMedicalService);

		// send over to our form
		return "/medical-services/medical-service-form";
	}

	@PostMapping("/save")
	public String saveSpeciaity(@ModelAttribute("medicalService") MedicalService theMedicalService) {

		// save the medical service
		medicalServiceService.save(theMedicalService);

		// use a redirect to prevent duplicate submissions
		return "redirect:/medical-services/list";
	}

	@GetMapping("/delete")
	public String deleteSpeciality(@RequestParam("medicalServiceId") int theId) {

		// delete the medical service
		medicalServiceService.deleteById(theId);

		return "redirect:/medical-services/list";
	}
}
