package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import org.apache.xmlbeans.UserType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public WebDriver driver;

	public WebDriver getWebDriver() throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String URL = prop.getProperty("URL");
		String browser = prop.getProperty("browser");
		if (driver == null) {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webDriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
				 driver = new ChromeDriver();

			}
			if (browser.equalsIgnoreCase("firefox")) {
				// implement firefox
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(URL);
		}
		return driver;
	}

}
