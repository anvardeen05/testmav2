package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeaftapsWrappers;

public class EditLeadPage extends LeaftapsWrappers{

	public EditLeadPage(RemoteWebDriver driver, ExtentTest testcase) {
		this.driver=driver;
		this.testcase=testcase;	
		if(!verifyTitle(" opentaps CRM")) {
			logStep("FAIL", "This is not Edit Lead Page");
			}		
	}
	
			
	
	
}
