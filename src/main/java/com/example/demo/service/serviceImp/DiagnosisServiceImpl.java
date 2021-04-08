package com.example.demo.service.serviceImp;


import com.example.demo.dao.DiagnosisRepository;
import com.example.demo.entity.Diagnosis;
import com.example.demo.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DiagnosisServiceImpl implements DiagnosisService {

	private DiagnosisRepository diagnosisRepository;

	@Autowired
	public DiagnosisServiceImpl(DiagnosisRepository theDiagnosisRepository) {
		diagnosisRepository = theDiagnosisRepository;
	}

	@Override
	public List<Diagnosis> findAll() {
		return diagnosisRepository.findAll();
	}

	@Override
	public Diagnosis findById(int theId) {
		Optional<Diagnosis> result = diagnosisRepository.findById(theId);

		Diagnosis theDiagnosis = null;

		if (result.isPresent()) {
			theDiagnosis = result.get();
		} else {
			// we didn't find the diagnosis
			throw new RuntimeException("Did not find diagnosis id - " + theId);
		}
		return theDiagnosis;
	}

	@Override
	public void save(Diagnosis theDiagnosis) {
		diagnosisRepository.save(theDiagnosis);
	}

	@Override
	public void deleteById(int theId) {
		diagnosisRepository.deleteById(theId);
	}

}
