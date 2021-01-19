package ie.cfl.school.domain.indication;

import java.time.LocalDateTime;

import ie.cfl.school.domain.student.Student;

public class Indicacao {

	private Student indicado;
	private Student indicante;
	private LocalDateTime dataIndicacao;
	
	public Indicacao(Student indicado, Student indicante) {
		this.indicado = indicado;
		this.indicante = indicante;
		this.dataIndicacao = LocalDateTime.now();
	}

	public Student getIndicado() {
		return indicado;
	}

	public void setIndicado(Student indicado) {
		this.indicado = indicado;
	}

	public Student getIndicante() {
		return indicante;
	}

	public void setIndicante(Student indicante) {
		this.indicante = indicante;
	}

	public LocalDateTime getDataIndicacao() {
		return dataIndicacao;
	}

	public void setDataIndicacao(LocalDateTime dataIndicacao) {
		this.dataIndicacao = dataIndicacao;
	}
	
	
}
