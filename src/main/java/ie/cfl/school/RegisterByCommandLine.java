package ie.cfl.school;

import ie.cfl.school.application.student.register.RegisterStudent;
import ie.cfl.school.application.student.register.RegisterStudentDTO;
import ie.cfl.school.domain.student.CPF;
import ie.cfl.school.domain.student.Student;
import ie.cfl.school.infra.student.StudentRepositoyInMemory;

public class RegisterByCommandLine {
	
	
	public static void main(String[] args) {
		String name = "Fulano da Silva";
		String cpf = "111.222.333-44";
		String emailAddress = "fulano@email.com";
		
		StudentRepositoyInMemory repository = new StudentRepositoyInMemory();
		
		
		RegisterStudent register = new RegisterStudent(repository);
		register.execute(new RegisterStudentDTO(name, cpf, emailAddress));
		
		Student s = repository.buscarPorCPF(new CPF(cpf));
		
		System.out.println("Student "+s.getName()+" successfull regitered.");
		
	}

}
