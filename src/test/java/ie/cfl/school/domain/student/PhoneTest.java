package ie.cfl.school.domain.student;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PhoneTest {

	@Test
	void shouldNotCreatePhoneWithDDDWrongFormat() {
		
		//Phone's DDD not present
		assertThrows(IllegalArgumentException.class, 
				()-> new Phone(null, "12345678"));
		
		//Phone's DDD empty
		assertThrows(IllegalArgumentException.class, 
				()-> new Phone("", "12345678"));
		
		//Phone's DDD more than 3 digits
		assertThrows(IllegalArgumentException.class, 
				()-> new Phone("123", "12345678"));

		//Phone's DDD less than 2 digits
		assertThrows(IllegalArgumentException.class, 
				()-> new Phone("1", "12345678"));
				
	}

	
	@Test
	void shouldNotCreatePhoneWithNumberWrongFormat() {
		
		//Phone's number with invalid characters
		assertThrows(IllegalArgumentException.class, 
				()-> new Phone("12", "abc12345"));
		
		//Phone's number empty
		assertThrows(IllegalArgumentException.class, 
				()-> new Phone("12", ""));
		
		//Phone's number more than 9 digits
		assertThrows(IllegalArgumentException.class, 
				()-> new Phone("12", "1234567891"));

		//Phone's DDD less than 8 digits
		assertThrows(IllegalArgumentException.class, 
				()-> new Phone("12", "1234567"));
				
	}
	
	@Test
	void phoneCreationSuccess() {
		String DDD = "34";
		String number8 = "99998888";
		String number9 = "999988887";
		
		Phone phone8 = new Phone(DDD, number8);
		Phone phone9 = new Phone(DDD, number9);
		
		assertTrue(phone8.getDdd().equals(DDD));
		assertTrue(phone8.getNumber().equals(number8));
		
		assertTrue(phone9.getDdd().equals(DDD));
		assertTrue(phone9.getNumber().equals(number9));
		
	}
}
