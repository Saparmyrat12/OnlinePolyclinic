package com.example.demo.service;


import com.example.demo.entity.Patient;
import java.util.List;

public interface PatientService {

	public List<Patient> findAll();

	public Patient findById(int theId);

	public void save(Patient thePatient);

	public void deleteById(int theId);

}
