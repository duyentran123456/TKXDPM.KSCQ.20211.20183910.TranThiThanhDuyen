package validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * class dung de validate cac thong tin dau vao
 * @author Duyen
 *
 */
public class InputValidator {
	public boolean validateName(String name) {
		if(name == null) return false;
		  
    	String regex = "^[A-Za-z]+$";
    	  
        Pattern p = Pattern.compile(regex);
  
        Matcher m = p.matcher(name);

        return m.matches();
	}
	
	public boolean validatePhoneNumber(String phoneNumber) {
		if(phoneNumber.length() != 10) {
    		return false;
    	}
    	if(!phoneNumber.startsWith("0")) return false;
    	try {
    		Integer.parseInt(phoneNumber);
    	} catch(NumberFormatException e) {
    		return false;
    	}
    	return true;
	}
	
	public boolean validateAddress(String address) {
		if(address == null) return false;
    	
    	String regex = "^[\\w\\s]+$";
  	  
        Pattern p = Pattern.compile(regex);
  
        Matcher m = p.matcher(address);

        return m.matches();
	}
}
