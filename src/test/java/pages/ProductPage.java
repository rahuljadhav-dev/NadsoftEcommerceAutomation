package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
	public ProductPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//button[normalize-space()='4'])")
	WebElement button;

	@FindBy(xpath = "(//p[normalize-space()='Apple Watch'])[1]")
	WebElement appleWatch;

	@FindBy(xpath = "/html/body/main/div[2]/div[2]/ul/li[11]/a/div/div[2]/div/p")
	WebElement priceOnListingPage;

	@FindBy(xpath = "//span[@class='!text-[#030712]']")
	WebElement priceOnProductPage;

	public void clickButton() {
		button.click();
	}

	public void clickOnProductIcon() {
		appleWatch.click();
	}

	public boolean validateThePrice() {
		if (priceOnListingPage.getText().equals(priceOnProductPage.getText())) {
			return true;
		} else {
			return false;
		}
	}

}
