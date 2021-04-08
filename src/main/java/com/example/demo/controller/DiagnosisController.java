package com.example.demo.controller;

import com.example.demo.entity.Diagnosis;
import com.example.demo.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/diagnoses")
public class DiagnosisController {

	private DiagnosisService diagnosisService;

	@Autowired
	public DiagnosisController(DiagnosisService theDiagnosisService) {
		diagnosisService = theDiagnosisService;
	}

	// list of diagnoses
	@GetMapping("/list")
	public String listDiagnoses(Model model) {

		// get diagnoses from database
		List<Diagnosis> theDiagnoses = diagnosisService.findAll();

		// add to the spring model
		model.addAttribute("diagnoses", theDiagnoses);

		return "/diagnoses/list-diagnoses";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {

		// create model attribute to bind form data
		Diagnosis theDiagnosis = new Diagnosis();

		model.addAttribute("diagnosis", theDiagnosis);

		// send over to our form
		return "/diagnoses/diagnosis-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("diagnosisId") int theId, Model model) {

		// get the diagnosis from the service
		Diagnosis theDiagnosis = diagnosisService.findById(theId);

		// set diagnosis as a model attribute to pre-populate the form
		model.addAttribute("diagnosis", theDiagnosis);

		// send over to our form
		return "/diagnoses/diagnosis-form";
	}

	@PostMapping("/save")
	public String saveDiagnosis(@ModelAttribute("diagnosis") Diagnosis theDiagnosis) {

		// save the diagnosis
		diagnosisService.save(theDiagnosis);

		return "redirect:/diagnoses/list";
	}

	@GetMapping("delete")
	public String deleteDiagnosis(@RequestParam("diagnosisId") int theId) {

		// delete the diagnosis
		diagnosisService.deleteById(theId);

		return "redirect:/diagnoses/list";
	}
}
