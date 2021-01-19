package ie.cfl.school.domain.student.interfaces;

import java.util.List;

import ie.cfl.school.domain.student.Student;
import ie.cfl.school.domain.student.CPF;

public interface StudentsRepository {

	void matricular(Student aluno);
	
	Student buscarPorCPF(CPF cpf);
	
	List<Student> listarTodosAlunosMatriculados();
}
