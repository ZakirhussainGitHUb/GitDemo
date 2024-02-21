package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TextContextSetup;

public class Hooks {
	TextContextSetup testContextSetup;

	public Hooks(TextContextSetup testContextSetup) {

		this.testContextSetup = testContextSetup;

	}

	@After
	public void AfterScenario() throws IOException {

		testContextSetup.testbase.getWebDriver().quit();

	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {
		WebDriver driver = testContextSetup.testbase.getWebDriver();
		if (scenario.isFailed()) {

			File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "image");
			
		}
	}
}