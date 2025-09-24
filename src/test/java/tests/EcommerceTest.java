package tests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class EcommerceTest extends BaseClass {

	@Test
	public void validateEcommerceFlow() throws InterruptedException {
		HomePage home = new HomePage(driver);
		ProductPage product = new ProductPage(driver);
		CartPage cart = new CartPage(driver);
		CheckoutPage checkout = new CheckoutPage(driver);

		home.clickOnShopNow();
		
		product.clickButton();
		product.clickOnProductIcon();
		product.validateThePrice();
		
		cart.addProductToCart();
		cart.goToTheCart();
		cart.increaseQty();
		cart.getPrice();
		
		checkout.clickOnCheckout();
		checkout.getSubtotal();
		
		
		
		

	}
}
