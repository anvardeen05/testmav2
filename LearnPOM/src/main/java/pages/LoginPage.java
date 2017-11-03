package pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import wrappers.LeaftapsWrappers;

public class LoginPage extends LeaftapsWrappers {
	
	public LoginPage(RemoteWebDriver driver, ExtentTest testcase) {
		this.driver=driver;
		this.testcase=testcase;
		if(!verifyTitle("Opentaps Open Source ERP + CRM")) {
			logStep("FAIL", "This is not Login Page");
		}		
    }
	
	public LoginPage typeUserName(String data) {
		enterById("username", data);
		return this;
	}
	
	public LoginPage typePassword(String data) {
		enterById("password", data);
		return this;
	}
	
	public HomePage clickLogin() {
		clickByXpath("//input[@value='Login']");
		return new HomePage(driver, testcase);
	}		
}
