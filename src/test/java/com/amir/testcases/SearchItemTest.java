package com.amir.testcases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.amir.base.TestBase;
import com.amir.utilities.TestUtil;

public class SearchItemTest extends TestBase {
	
	static String modelname;
	
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void searchItemTest(Hashtable<String, String> data) throws InterruptedException {

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		
		final String details;
		
		//typing item name getting from excel sheet
		type("input_XPATH",data.get("itemname"));
		
		//clicking on search button
		click("searchbutton_XPATH");
		
		//getting model name from excel sheet
		modelname = data.get("modelname");
		
		//searching model name using contains (text())
		WebElement item = driver.findElement(By.xpath("//*[contains (text(),'"+modelname+"')]"));
		
		isElementPresent(By.xpath("//*[contains (text(),'"+modelname+"')]"));
		
		//getting parent of element (block) to get details
		WebElement parent = driver.findElement(By.xpath("//*[contains (text(),'"+modelname+"')]/.."));
		details = parent.getText();
		
		System.out.println("Details of the product are:");
		System.out.println(details);
		item.click();
	}
}