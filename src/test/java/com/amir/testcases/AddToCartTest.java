package com.amir.testcases;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.amir.base.TestBase;
import com.amir.utilities.TestUtil;

public class AddToCartTest extends TestBase {

	
	static String description;
	
	@Test
	public void addToCartTest() throws InterruptedException {

	
		//getting window handles as two windows as present
		Set<String> winids = driver.getWindowHandles();
		
		Iterator<String> iterate = winids.iterator();
		
		//first window
		String first_window = iterate.next();
		
		//second window
		String second_window = iterate.next();
		
		driver.switchTo().window(second_window);
		
		//getting description of item
		WebElement item_desc = driver.findElement(By.xpath(OR.getProperty("item_heading_XPATH")));
		
		//getting text out of item_desc
		String long_description = item_desc.getText();
		
		int beginIndex = long_description.indexOf("(");
		
		int endIndex = long_description.indexOf(")");
		
		//getting substring inside brackets
		description = long_description.substring(beginIndex+1, endIndex);
		
		click("add_cart_button_XPATH");
	}
}
