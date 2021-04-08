package com.example.demo.service.serviceImp;


import com.example.demo.dao.PatientRepository;
import com.example.demo.entity.Patient;
import com.example.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

	private PatientRepository patientRepository;

	@Autowired
	public PatientServiceImpl(PatientRepository thePatientRepositiry) {
		patientRepository = thePatientRepositiry;
	}

	@Override
	public List<Patient> findAll() {
		return patientRepository.findAll();
	}

	@Override
	public Patient findById(int theId) {
		Optional<Patient> result = patientRepository.findById(theId);

		Patient thePatient = null;

		if (result.isPresent()) {
			thePatient = result.get();
		} else {
			throw new RuntimeException("Did not find patient id - " + theId);
		}
		return thePatient;
	}

	@Override
	public void save(Patient thePatient) {
		patientRepository.save(thePatient);

	}

	@Override
	public void deleteById(int theId) {
		patientRepository.deleteById(theId);
	}

}
