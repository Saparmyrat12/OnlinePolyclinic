package com.example.demo.controller;


import com.example.demo.entity.Visit;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/visits")
public class VisitController {

    private VisitService visitService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private MedicalServiceService medicalServiceService;

    @Autowired
    private DiagnosisService diagnosisService;

    @Autowired
    public VisitController(VisitService theVisitService) {
        visitService = theVisitService;
    }

    // list of visits
    @GetMapping("/list")
    public String listVisits(Model theModel) {

        // get visits from database
        List<Visit> theVisits = visitService.findAll();

        // add to the spring model
        theModel.addAttribute("visits", theVisits);

        return "/visits/list-visits";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Visit theVisit = new Visit();

        theModel.addAttribute("visit", theVisit);
        theModel.addAttribute("patients", patientService.findAll());
        theModel.addAttribute("doctors", doctorService.findAll());
        //theModel.addAttribute("medicalServices", medicalServiceService.findAll());
        theModel.addAttribute("diagnoses", diagnosisService.findAll());

        return "/visits/visit-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("visitId") int theId, Model theModel) {

        // get the visit from the service
        Visit theVisit = visitService.findById(theId);

        // set visit as a model attribute to pre-populate the form
        theModel.addAttribute("visit", theVisit);
        theModel.addAttribute("patients", patientService.findAll());
        theModel.addAttribute("doctors", doctorService.findAll());
        //theModel.addAttribute("medicalServices", medicalServiceService.findAll());
        theModel.addAttribute("diagnoses", diagnosisService.findAll());

        // send over to our form
        return "visits/visit-form";
    }

    @PostMapping("/save")
    public String saveVisit(@ModelAttribute("visit") Visit theVisit) {

        // save the visit
        visitService.save(theVisit);

        // use a redirect to prevent duplicate submissions
        return "redirect:/visits/list";
    }

    @GetMapping("/delete")
    public String deleteVisit(@RequestParam("visitId") int theId) {

        // delete the visit
        visitService.deleteById(theId);

        return "redirect:/visits/list";
    }
}
