package mm.edu.ec.mtu.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import mm.edu.ec.mtu.model.entity.Teacher;
import mm.edu.ec.mtu.model.repo.TeacherRepo;

@Service
@Transactional(readOnly = true)
public class TeacherService {

	@Autowired
	private TeacherRepo teacherRepo;

	public List<Teacher> search(String keyword) {
		
		List<Specification<Teacher>> list = new ArrayList<>();
		
		if(StringUtils.hasLength(keyword)) {

			String pattern = "%" + keyword.toLowerCase() + "%";
			
			Specification<Teacher> whichKeyword = (root, query, cb) -> {
				var teacherName = cb.like(cb.lower(root.get("name")), pattern);
				var teacherPosition = cb.like(cb.lower(root.get("position")),pattern);
				var teacherEducation = cb.like(cb.lower(root.get("education")), keyword.toLowerCase().concat("%"));

				return cb.or(teacherName, teacherPosition, teacherEducation);
			};
			list.add(whichKeyword);
		}

		return teacherRepo.findAll(Specification.allOf(list));
	}

	public Optional<Teacher> getTeacherById(Integer id) {
		return Optional.ofNullable(teacherRepo.findById(id)).orElseThrow();
	}

	@Transactional
	public void save(Teacher teacher) {
		teacherRepo.save(teacher);
	}
}
