package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//*[@id='no-tailwindcss-base']/section/div/div/div[2]/div[7]/div[1]/div[2]/span")
	WebElement goToCheckout;

	@FindBy(css = "div:nth-child(7) div:nth-child(1) div:nth-child(2) span:nth-child(1)")
	WebElement subTotal;

	@FindBy(xpath = "//*[@id='no-tailwindcss-base']/section/div/div/div[2]/div[7]/div[2]/div[2]/span")
	WebElement shippingCharges;

	@FindBy(xpath = "//*[@id='no-tailwindcss-base']/section/div/div/div[2]/div[7]/div[3]/div[2]/span")
	WebElement taxes;

	public void clickOnCheckout() {
		goToCheckout.click();
	}

	public double getSubtotal() {
		return Double.parseDouble(subTotal.getText().replace("$", "").trim());
	}

}
