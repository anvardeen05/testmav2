package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeaftapsWrappers;

public class HomePage extends LeaftapsWrappers {

	public HomePage(RemoteWebDriver driver, ExtentTest testcase) {
		this.driver = driver;
		this.testcase = testcase;
		if (!verifyTitle("Opentaps Open Source ERP + CRM")) {
			logStep("FAIL", "This is not Home Page");
		}
	}
	
	public MyHomePage clickCRMSFA() {
		clickByLink("CRM/SFA");
		return new MyHomePage(driver, testcase);
	}	

	public LoginPage clickLogout() {
		clickByClassName("decorativeSubmit");
		return new LoginPage(driver, testcase);
	}

}
