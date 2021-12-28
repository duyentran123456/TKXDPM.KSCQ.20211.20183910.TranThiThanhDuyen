package controller;

import java.util.HashMap;
import java.util.Random;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.media.Media;
import entity.order.Order;
import shippingFee.RushShippingFeeCalculator;

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
	
	public void placeRushOrder(Order order, HashMap deliveryInfo) {
		if(!order.checkRushSupport()) return;
		
		order.setShippingFee(new RushShippingFeeCalculator());
		order.setDeliveryInfo(deliveryInfo);
	}
		
}
