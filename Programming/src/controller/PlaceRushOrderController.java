package controller;

import java.util.Random;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.media.Media;
import entity.order.Order;

/**
 * class giup them chuc nang dat hang nhanh
 * @author Duyen
 *
 */
public class PlaceRushOrderController {
	
	/**
	 * dung de logging
	 */
	private static Logger LOGGER = utils.Utils.getLogger(PlaceOrderController.class.getName());
	
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
	public boolean checkMediaRushSupport(Media media) {
		if(media == null) return false;
		
		if(!media.getRushSupport()) return false;
		
		return true;
	}
	
	/**
	 * tinh gia tri phi ship moi
	 * @param order: don hang su dung dat hang nhanh
	 * @return fees: phi ship moi
	 */
	public int calculateShippingFee(Order order) {
		Random rand = new Random();
		int fees = (int)( ( (rand.nextFloat()*10)/100 ) * order.getAmount() );
		LOGGER.info("Order Amount: " + order.getAmount() + " -- Shipping Fees: " + fees);
		return fees;
	}
	
}
