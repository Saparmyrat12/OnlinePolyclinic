package com.example.demo.service;


import com.example.demo.entity.MedicalService;
import java.util.List;

public interface MedicalServiceService {

	public List<MedicalService> findAll();

	public MedicalService findById(int theId);

	public void save(MedicalService theMedicalService	);

	public void deleteById(int theId);
}
