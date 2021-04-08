package com.example.demo.service;


import com.example.demo.entity.Speciality;
import java.util.List;

public interface SpecialityService {

	public List<Speciality> findAll();

	public Speciality findById(int theId);

	public void save(Speciality theDoctor);

	public void deleteById(int theId);
}
