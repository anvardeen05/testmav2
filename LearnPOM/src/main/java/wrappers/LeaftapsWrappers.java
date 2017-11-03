package wrappers;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utils.DataInputProvider;

public class LeaftapsWrappers extends GenericWrappers {
	public String excelName, testcaseName, testDescription, author, category;

	@BeforeSuite
	public void beforeSuite() {
		createReport();
	}

	// Static data
	@Parameters({ "browser", "url" })
	@BeforeMethod
	public void login(String browser, String url) {
		createTestReport(testcaseName, testDescription, author, category);
		invokeApp(browser, url);
	}

	@AfterMethod
	public void close() {
		closeBrowser();
		closeTestReport();
	}
	
	@AfterClass
	public void afterClass()
	{
		
	}
	@AfterTest
	public void afterTest(){
		
	}
	@AfterSuite
	public void afterSuite(){
		saveReport();
	}

	// Dynamic values
	// Read the create lead from excel sheet
	@DataProvider(name = "fetchExcelData")
	public Object[][] getExcelData() throws InvalidFormatException, IOException {
		DataInputProvider re = new DataInputProvider();
		Object[][] data = re.readExcel(excelName);
		return data;
	}
	/*
	 * @DataProvider (name="createLead") public Object[][] getCreateLoadData(){
	 * {"Oracle","Ganesh","R"} };
	 * Object[][] data = new Object[][]{ {"Testleaf","Ganesh","R"},
	 * 
	 * return data; }
	 */

}
