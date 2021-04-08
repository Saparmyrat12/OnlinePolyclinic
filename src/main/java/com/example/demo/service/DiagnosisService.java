package com.example.demo.service;


import com.example.demo.entity.Diagnosis;
import java.util.List;

public interface DiagnosisService {

public List<Diagnosis> findAll();
	
	public Diagnosis findById(int theId);
	
	public void save(Diagnosis theDiagnosis);
	
	public void deleteById(int theId);
}
