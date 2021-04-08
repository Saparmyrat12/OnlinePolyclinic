package com.example.demo.controller;


import com.example.demo.entity.Patient;
import com.example.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientController {

	private PatientService patientService;
	
	@Autowired
	public PatientController(PatientService thePatientService) {
		patientService = thePatientService;
	}

	// list of patients
	@GetMapping("/list")
	public String listPatients(Model theModel) {

		// get patients from database
		List<Patient> thePatients = patientService.findAll();

		// add to the spring model
		theModel.addAttribute("patients", thePatients);

		return "/patients/list-patients";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Patient thePatient = new Patient();

		theModel.addAttribute("patient", thePatient);

		return "/patients/patient-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("patientId") int theId, Model theModel) {

		// get the patient from the service
		Patient thePatient = patientService.findById(theId);

		// set patient as a model attribute to pre-populate the form
		theModel.addAttribute("patient", thePatient);

		// send over to our form
		return "patients/patient-form";
	}

	@PostMapping("/save")
	public String savePatient(@ModelAttribute("patient") Patient thePatient) {

		// save the patient
		patientService.save(thePatient);

		// use a redirect to prevent duplicate submissions
		return "redirect:/patients/list";
	}

	@GetMapping("/delete")
	public String deletePatient(@RequestParam("patientId") int theId) {

		// delete the patient
		patientService.deleteById(theId);

		return "redirect:/patients/list";
	}
}
