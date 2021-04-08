package com.example.demo.dao;

import com.example.demo.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

	// method to sort by last name
	 List<Doctor> findByOrderByLastNameAsc();
}
