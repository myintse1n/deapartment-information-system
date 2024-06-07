package mm.edu.ec.mtu.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mm.edu.ec.mtu.model.entity.AcademicYear;
import mm.edu.ec.mtu.model.entity.StudentThesis;
import mm.edu.ec.mtu.model.repo.AcademicYearRepo;
import mm.edu.ec.mtu.model.repo.StudentThesisRepo;

@Service
public class ThesisService {

	@Autowired
	private AcademicYearRepo academicYearRepo;

	@Autowired
	private StudentThesisRepo studentThesisRepo;

	public List<StudentThesis> getThesesByYear(String year) {
		AcademicYear academicYear = academicYearRepo.streamByYear(year)
				.orElseThrow(() -> new RuntimeException("Year not found"));
		return studentThesisRepo.findAllByAcademicYear(academicYear);
	}
}
