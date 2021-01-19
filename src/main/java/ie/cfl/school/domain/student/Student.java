package ie.cfl.school.domain.student;

import java.util.ArrayList;
import java.util.List;

public class Student {
	
	private String name;
	private CPF cpf;	
	private Email email;

	private List<Phone> phones = new ArrayList<>();
	
	private String password;
	
	public Student(String name, CPF cpf, Email email) {
		this.name = name;
		this.cpf = cpf;
		this.email = email;
	}

	public void addPhone(Phone phone) {
		this.phones.add(phone);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CPF getCpf() {
		return cpf;
	}

	public void setCpf(CPF cpf) {
		this.cpf = cpf;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public List<Phone> getPhones() {
		return phones;
	}
	
}
