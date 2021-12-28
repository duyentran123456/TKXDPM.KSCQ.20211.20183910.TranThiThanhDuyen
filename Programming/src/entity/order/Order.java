package entity.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import shippingFee.IShippingFeeCalculator;
import utils.Configs;
import validation.RushSupportValidator;

public class Order {
    
    private int shippingFees;
    private List<OrderMedia> lstOrderMedia;
    private HashMap<String, String> deliveryInfo;

    public Order(){
        this.lstOrderMedia = new ArrayList<>();
    }

    public Order(List lstOrderMedia) {
        this.lstOrderMedia = lstOrderMedia;
    }

    public void addOrderMedia(OrderMedia om){
        this.lstOrderMedia.add(om);
    }

    public void removeOrderMedia(OrderMedia om){
        this.lstOrderMedia.remove(om);
    }

    public List getlstOrderMedia() {
        return this.lstOrderMedia;
    }

    public void setlstOrderMedia(List lstOrderMedia) {
        this.lstOrderMedia = lstOrderMedia;
    }

    public void setShippingFees(int shippingFees) {
        this.shippingFees = shippingFees;
    }

    public int getShippingFees() {
        return shippingFees;
    }

    public HashMap getDeliveryInfo() {
        return deliveryInfo;
    }

    public void setDeliveryInfo(HashMap deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
    }

    public int getAmount(){
        double amount = 0;
        for (Object object : lstOrderMedia) {
            OrderMedia om = (OrderMedia) object;
            amount += om.getPrice();
        }
        return (int) (amount + (Configs.PERCENT_VAT/100)*amount);
    }
    
    public void setShippingFee(IShippingFeeCalculator calculator) {
    	this.shippingFees = calculator.calculateShippingFee(this.getAmount());
    }
    
    public boolean checkRushSupport() {
    	RushSupportValidator validator = new RushSupportValidator();
    	
    	if(!validator.checkAddressRushSupport(this.deliveryInfo.get("address"))) return false;
    	for(OrderMedia orderMedia: this.lstOrderMedia) {
    		if(validator.checkMediaRushSupport(orderMedia)) return false;
    	}
    	
    	return true;
    }

}
