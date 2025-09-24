package pages;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {
	public CartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//button[normalize-space()='Add to cart'])[1]")
	WebElement addToCart;

	@FindBy(xpath = "//a[starts-with(normalize-space(),'Cart')]")
	WebElement cart;

	@FindBy(css=".svg-inline--fa.fa-plus.fa-sm") 
	WebElement plusButton;

	@FindBy(xpath = "(//span[contains(@class,'block text-[#030712] !text-[18px] !font-[500] tracking-[-0.33px] store-front-font-family-match-medusa')])[1]")
	WebElement price;

	private void scrollAndClick(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			try {
				element.click();
			} catch (Exception e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			}
		} catch (Exception e) {
			System.out.println("Failed to click element: " + element);
			e.printStackTrace();
		}
	}

	public void addProductToCart() {
		scrollAndClick(addToCart);
	}

	public void goToTheCart() {
		scrollAndClick(cart);
	}

	public void increaseQty() {
		scrollAndClick(plusButton);
	}

	public String getPrice() {
		return price.getText();
	}

}
