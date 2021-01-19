package ie.cfl.school.infra.student;

import java.util.ArrayList;
import java.util.List;

import ie.cfl.school.domain.student.Student;
import ie.cfl.school.domain.student.CPF;
import ie.cfl.school.domain.student.StudentNotFoundException;
import ie.cfl.school.domain.student.interfaces.StudentsRepository;

public class StudentRepositoyInMemory implements StudentsRepository {

	private List<Student> matriculados = new ArrayList<>();
	
	@Override
	public void matricular(Student aluno) {
		this.matriculados.add(aluno);
	}

	@Override
	public Student buscarPorCPF(CPF cpf) {
		return this.matriculados.stream()
				.filter(a -> a.getCpf().equals(cpf.getNumber()))
				.findFirst()
				.orElseThrow(() -> new StudentNotFoundException(cpf));
	}

	@Override
	public List<Student> listarTodosAlunosMatriculados() {
		return this.matriculados;
	}

}
