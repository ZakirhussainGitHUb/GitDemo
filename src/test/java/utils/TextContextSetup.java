package utils;

import java.io.IOException;

import pageObject.PageObjectManager;

public class TextContextSetup {
	
	public String landingPageProductName;
	public PageObjectManager pageObjectManager;
	public TestBase testbase;
	
	
	public TextContextSetup() throws IOException {
		 testbase= new TestBase();
		 pageObjectManager = new PageObjectManager(testbase.getWebDriver());
	}

}
