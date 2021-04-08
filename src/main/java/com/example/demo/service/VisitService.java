package com.example.demo.service;


import com.example.demo.entity.Visit;
import java.util.List;

public interface VisitService {

	public List<Visit> findAll();

	public Visit findById(int theId);

	public void save(Visit theVisit);

	public void deleteById(int theId);
}
