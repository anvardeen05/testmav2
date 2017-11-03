package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeaftapsWrappers;

public class CreateLeadPage extends LeaftapsWrappers{

	public CreateLeadPage(RemoteWebDriver driver, ExtentTest testcase) {
		this.driver=driver;
		this.testcase=testcase;	
		if(!verifyTitle("Create Lead | opentaps CRM")) {
			logStep("FAIL", "This is not Create Lead Page");
			}		
	}
	
	public CreateLeadPage typeCompanyName(String data) {
		enterById("createLeadForm_companyName", data);
		return this;
	}
	
	public CreateLeadPage typeFirstName(String data) {
		enterById("createLeadForm_firstName", data);
		return this;
	}
	public CreateLeadPage typeLastName(String data) {
		enterById("createLeadForm_lastName", data);
		return this;	
	}
	public ViewLeadPage clickCreateLeadButton() {
		clickByClassName("smallSubmit");		
		return new ViewLeadPage(driver, testcase);	
	}
}
