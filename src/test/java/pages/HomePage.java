package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@href='/store']")
	WebElement shopNow;

	public void clickOnShopNow() {
		System.out.println(shopNow.getText());
		shopNow.click();
	}

}
