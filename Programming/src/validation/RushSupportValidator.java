package validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.media.Media;
import entity.order.OrderMedia;

public class RushSupportValidator {
	/**
	 * kiem tra dia chi co ho tro dat hang nhanh hay khong
	 * @param address: dia chi nhan hang
	 * @return result
	 */
	public boolean checkAddressRushSupport(String address) {
		if(address == null) return false;
    	
    	String regex = "^[\\w\\s]+$";
  	  
        Pattern p = Pattern.compile(regex);
  
        Matcher m = p.matcher(address);
        
        boolean isInHaNoi = address.toLowerCase().contains("ha noi") || address.toLowerCase().contains("hà nội");

        return m.matches() && isInHaNoi;
	}
	
	/**
	 * kiem tra san pham co ho tro dat hang nhanh hay khong
	 * @param media: san pham trong don hang
	 * @return result
	 */
	public boolean checkMediaRushSupport(OrderMedia orderMedia) {
		if(orderMedia == null) return false;
		
		if(!orderMedia.getMedia().getRushSupport()) return false;
		
		return true;
	}
}
