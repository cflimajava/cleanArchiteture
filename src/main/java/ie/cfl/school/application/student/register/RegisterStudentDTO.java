package ie.cfl.school.application.student.register;

import ie.cfl.school.domain.student.Student;
import ie.cfl.school.domain.student.StudentBuilder;

public class RegisterStudentDTO {
	
	public String name;
	public String cpf;
	public String emailAddress;
	
	public RegisterStudentDTO(String name, String cpf, String emailAddress) {
		this.name = name;
		this.cpf = cpf;
		this.emailAddress = emailAddress;
	}
	
	public Student createStudant() {
		return new StudentBuilder()
				.withNameCPFEmail(name, cpf , emailAddress)
				.build();
	}
	

}
