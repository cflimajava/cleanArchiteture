package ie.cfl.school.infra.student;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import ie.cfl.school.domain.student.interfaces.Encoder;

public class MD5encoder implements Encoder{

	@Override
	public String encode(String value) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			 
	        BigInteger hash = new BigInteger(1, md.digest(value.getBytes()));
	 
	        return String.format("%32x", hash);
			
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Error to encode password: "+ e.getMessage());
		}
	}

	@Override
	public boolean encodeValidator(String MD5Value, String defaulValue) {
		return MD5Value.equals(encode(defaulValue));
	}

}
