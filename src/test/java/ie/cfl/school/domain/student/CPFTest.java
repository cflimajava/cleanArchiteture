package ie.cfl.school.domain.student;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CPFTest {

	@Test
	void shouldNotCreateCPFWithWrongFormatNumber() {
		
		assertThrows(IllegalArgumentException.class, 
				()-> new CPF(null));
		
		assertThrows(IllegalArgumentException.class, 
				()-> new CPF(""));
		
		assertThrows(IllegalArgumentException.class, 
				()-> new CPF("12345678912"));
		
	}
	
	@Test
	void createCPFSuccess() {
		String number = "060.346.506-40";
		CPF cpf = new CPF(number);
		
		assertTrue(cpf.getNumber().equals(number));
		
	}

}
