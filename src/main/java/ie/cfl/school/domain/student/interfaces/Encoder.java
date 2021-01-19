package ie.cfl.school.domain.student.interfaces;

public interface Encoder {
	
	String encode(String value);
	
	boolean encodeValidator(String value, String defaulValue);

}
