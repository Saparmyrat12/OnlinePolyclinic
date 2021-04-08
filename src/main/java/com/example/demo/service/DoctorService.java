package com.example.demo.service;


import com.example.demo.entity.Doctor;
import java.util.List;

public interface DoctorService {

	public List<Doctor> findAll();
	
	public Doctor findById(int theId);
	
	public void save(Doctor theDoctor);
	
	public void deleteById(int theId);
}
