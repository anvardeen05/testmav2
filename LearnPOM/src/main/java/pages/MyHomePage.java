package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeaftapsWrappers;

public class MyHomePage extends LeaftapsWrappers {

	public MyHomePage(RemoteWebDriver driver, ExtentTest testcase) {
		this.driver = driver;
		this.testcase = testcase;
		if (!verifyTitle("My Home | opentaps CRM")) {
			logStep("FAIL", "This is not My Home Page");
		}
	}

	public CreateLeadPage clickCreateLead() {
		clickByLink("Create Lead");
		return new CreateLeadPage(driver, testcase);
	}	
	
	public LeadsPage clickLeads(){
		clickByLink("Leads");
		return new LeadsPage(driver, testcase);
	}
	
	
}