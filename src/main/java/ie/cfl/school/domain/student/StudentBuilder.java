package ie.cfl.school.domain.student;

public class StudentBuilder {
	
	private Student aluno;
	
	public StudentBuilder withNameCPFEmail(String name, String cpf, String email) {
		this.aluno = new Student(name, new CPF(cpf), new Email(email));
		return this;
	}
	
	public StudentBuilder withPhone(String DDD, String number) {
		this.aluno.addPhone(new Phone(DDD, number));
		return this;
	}
	
	public Student build() {
		return this.aluno;
	}

}
