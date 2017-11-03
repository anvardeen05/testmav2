package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LeaftapsWrappers;

public class TC001_Login extends LeaftapsWrappers{
	
	@BeforeClass
	public void beforeClass() {
		excelName="TC001";
		testcaseName="Login";
		testDescription="Login to leaftaps";
		author = "Anvar";
		category = "Smoke";
	}	
	
	@Test(dataProvider="fetchExcelData")
	public void loginPage(String username, String password, String errormessage) {		
		new LoginPage(driver, testcase)
	    .typeUserName(username)
		.typePassword(password)		
		.clickLogin();
	}
}
