package ie.cfl.school.domain.student;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class EmailTest {

	@Test
	void shouldNotCreateEmailWithWrongAddressFormat() {
		assertThrows(IllegalArgumentException.class, 
				()-> new Email(null));
		
		assertThrows(IllegalArgumentException.class, 
				()-> new Email(""));
		
		assertThrows(IllegalArgumentException.class, 
				()-> new Email("InvalidEmail"));
	}
	
	@Test
	void successEmailCreation() {
		
		String address = "email@valido.com";		
		Email email = new Email(address);

		assertTrue(email.getAddress().equals(address));
		
	}

}
