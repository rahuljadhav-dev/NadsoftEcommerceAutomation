package base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public Properties properties;
	public FileInputStream file;

	@BeforeClass
	@Parameters({ "browser" })
	public void launchApplication(String br) {
		try {
			file = new FileInputStream("./src//test//resources//config.properties");
			properties = new Properties();
			properties.load(file);

			switch (br.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			default:
				System.out.println("Invalid Browser Name...");
				return;
			}

			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
			driver.get(properties.getProperty("url"));
			driver.manage().window().maximize();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to launch application: " + e.getMessage());
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
