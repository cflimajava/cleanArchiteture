package ie.cfl.school.infra.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ie.cfl.school.domain.student.StudentNotFoundException;
import ie.cfl.school.domain.student.Phone;
import ie.cfl.school.domain.student.Student;
import ie.cfl.school.domain.student.CPF;
import ie.cfl.school.domain.student.Email;
import ie.cfl.school.domain.student.interfaces.StudentsRepository;

public class StudentRepositoyJDBC implements StudentsRepository {

	private final Connection connection;
	
	public StudentRepositoyJDBC(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void matricular(Student aluno) {
		try {
			String sql = "INSERT INTO ALUNO VALUES(?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, aluno.getCpf().getNumber());
			ps.setString(2, aluno.getName());
			ps.setString(3, aluno.getEmail().getAddress());
			ps.execute();
			
			sql = "INSERT INTO TELEFONE VALUES(?, ?)";
			ps = connection.prepareStatement(sql);
			for (Phone telefone : aluno.getPhones()) {
				ps.setString(1, telefone.getDdd());
				ps.setString(2, telefone.getNumber());
				ps.execute();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Student buscarPorCPF(CPF cpf) {
		try {
			String sql = "SELECT id, nome, email FROM ALUNO WHERE cpf = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, cpf.getNumber());

			ResultSet rs = ps.executeQuery();
			boolean encontrou = rs.next();
			if (!encontrou) {
				throw new StudentNotFoundException(cpf);
			}

			String nome = rs.getString("nome");
			Email email = new Email(rs.getString("email"));
			Student encontrado = new Student(nome, cpf, email);
			
			Long id = rs.getLong("id");
			sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
			ps = connection.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				String numero = rs.getString("numero");
				String ddd = rs.getString("ddd");
				encontrado.addPhone(new Phone(ddd, numero));
			}
			
			return encontrado;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Student> listarTodosAlunosMatriculados() {
		try {
			String sql = "SELECT id, cpf, nome, email FROM ALUNO";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Student> alunos = new ArrayList<>();
			while (rs.next()) {
				CPF cpf = new CPF(rs.getString("cpf"));
				String nome = rs.getString("nome");
				Email email = new Email(rs.getString("email"));
				Student aluno = new Student(nome, cpf, email);
				
				Long id = rs.getLong("id");
				sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
				PreparedStatement psTelefone = connection.prepareStatement(sql);
				psTelefone.setLong(1, id);
				ResultSet rsTelefone = psTelefone.executeQuery();
				while (rsTelefone.next()) {
					String numero = rsTelefone.getString("numero");
					String ddd = rsTelefone.getString("ddd");
					aluno.addPhone(new Phone(ddd, numero));
				}
			
				alunos.add(aluno);
			}
			
			return alunos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
