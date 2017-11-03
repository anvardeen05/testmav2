package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeaftapsWrappers;

public class MyLeadsPage extends LeaftapsWrappers{
	
	public MyLeadsPage(RemoteWebDriver driver, ExtentTest testcase) {
		this.driver=driver;
		this.testcase=testcase;	
		if(!verifyTitle("My Leads | opentaps CRM")) {
			logStep("FAIL", "This is not MyLeads Page");
			}		
	}
	
	public ViewLeadPage clickFirstLink(){
		clickByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		return new ViewLeadPage(driver, testcase);		
	}	
}
