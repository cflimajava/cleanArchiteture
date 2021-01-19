package ie.cfl.school.domain.student;

public class StudentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StudentNotFoundException(CPF cpf) {
		super("Aluno nao encontrado com CPF: " + cpf.getNumber());
	}

}
