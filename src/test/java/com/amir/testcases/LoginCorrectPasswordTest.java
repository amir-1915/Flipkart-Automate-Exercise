package com.amir.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.amir.base.TestBase;
import com.amir.utilities.TestUtil;

public class LoginCorrectPasswordTest extends TestBase {

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void loginCorrectPasswordTest(Hashtable<String, String> data) throws InterruptedException {

		if (!data.get("runmode").equals("Y")) {

			throw new SkipException("Skipping the test case as the Run mode for data set is NO");
		}
		
		//type method defined in TestBase
		type("email_XPATH",data.get("username"));
		
	
		type("password_XPATH",data.get("password"));
		
		//click method defined in TestBase
		click("button_XPATH");
		
		
		

	}
}
