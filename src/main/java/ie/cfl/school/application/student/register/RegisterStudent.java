package ie.cfl.school.application.student.register;

import ie.cfl.school.domain.student.interfaces.StudentsRepository;

public class RegisterStudent {
	
	private final StudentsRepository repository;

	public RegisterStudent(StudentsRepository repository) {
		this.repository = repository;
	}
	
	
	public void execute(RegisterStudentDTO dto) {
		repository.matricular(dto.createStudant());
	}
	

}
