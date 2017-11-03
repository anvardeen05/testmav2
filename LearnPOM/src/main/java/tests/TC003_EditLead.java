package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CreateLeadPage;
import pages.LoginPage;
import wrappers.GenericWrappers;
import wrappers.LeaftapsWrappers;

public class TC003_EditLead extends LeaftapsWrappers {
	
	@BeforeClass
	public void beforeClass() {
		excelName="TC002";
		testcaseName="Edit Lead";
		testDescription="Create Lead to leaftaps";
		author = "Anvar";
		category = "Smoke";
	}	
	
	@Test(dataProvider="fetchExcelData")
	public void createLead(String userName, String password, String companyName, String firstName, String lastName) {
		new LoginPage(driver, testcase)
	    .typeUserName(userName)
		.typePassword(password)
		.clickLogin()
		.clickCRMSFA()
		.clickLeads()
		.clickMyLeads()
		.clickFirstLink()
		.clickEditButton()
		.clickUpdateButton();
		
		/*.typeCompanyName(companyName)
		.typeFirstName(firstName)
		.typeLastName(lastName)
		.clickCreateLeadButton()
		.verifyLeadFirstName(firstName);
		*/
		/*clickByLink("Create Lead");
		enterById("createLeadForm_companyName", "Raj Infotech");
		enterById("createLeadForm_firstName", "Rajkumar");
		enterById("createLeadForm_lastName", "Balakrishnan");

		// Select drop down values

		selectVisibileTextById("createLeadForm_dataSourceId", "Partner");
		selectVisibileTextById("createLeadForm_marketingCampaignId", "Automobile");
		enterById("createLeadForm_firstNameLocal", "RajFirst");
		enterById("createLeadForm_lastNameLocal", "KumarLast");
		enterById("createLeadForm_personalTitle", "Mr.");
		enterById("createLeadForm_generalProfTitle", "Profile Title");
		enterById("createLeadForm_departmentName", "ECE");
		enterById("createLeadForm_annualRevenue", "27,000");
		selectVisibileTextById("createLeadForm_currencyUomId", "INR - Indian Rupee");
		enterById("createLeadForm_numberEmployees", "64");
		selectVisibileTextById("createLeadForm_industryEnumId", "Computer Software");
		selectVisibileTextById("createLeadForm_ownershipEnumId", "S-Corporation");
		clickByClassName("smallSubmit");
*/	}
}
