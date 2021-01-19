package ie.cfl.school.application.interfaces;

import ie.cfl.school.domain.student.Student;

public interface SendIndicatorEmail {

	void sendTo(Student student);
	
}
