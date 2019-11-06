package com.amir.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amir.base.TestBase;

public class MyCartTest extends TestBase {

	@Test
	public void myCartTest() throws Throwable {

		// getting item name
		WebElement item = driver.findElement(By.xpath(OR.getProperty("item_XPATH")));

		// getting text
		String item_cart_text = item.getText();

		// getting item details
		WebElement detail = driver.findElement(By.xpath(OR.getProperty("detail_XPATH")));

		String detail_cart_text = detail.getText();

		//this method defined in TestBase class
		verifyEquals(SearchItemTest.modelname, item_cart_text);

		verifyEquals(AddToCartTest.description, detail_cart_text);

		click("place_order_XPATH");
	}
}
