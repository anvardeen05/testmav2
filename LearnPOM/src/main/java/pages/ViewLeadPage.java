package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeaftapsWrappers;

public class ViewLeadPage extends LeaftapsWrappers {
	
	public ViewLeadPage(RemoteWebDriver driver, ExtentTest testcase) {
		this.driver=driver;
		this.testcase=testcase;	
		if(!verifyTitle("View Lead | opentaps CRM")) {
			logStep("FAIL", "This is not View Lead Page");
			}		
	}	
	
	public ViewLeadPage clickEditButton(){
		clickByLink("Edit");
		return this;
	}
	
	public ViewLeadPage clickUpdateButton(){
		clickByXpath("//input[@value='Update']");
		return new ViewLeadPage(driver,testcase);		
	}
	public ViewLeadPage verifyLeadFirstName(String firstName){
		verifyTextById("viewLead_firstName_sp", firstName);
		return this;		
	}
	
}
