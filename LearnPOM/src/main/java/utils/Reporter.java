package utils;

import java.io.File;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reporter {
	static ExtentReports report;
	public ExtentTest testcase;
	public void createReport()
	{
		report=new ExtentReports("./report/report.html", false);		
		report.loadConfig(new File("./report-config.xml"));		
	}
	public void createTestReport(String testcaseName, String testDescription, String author, String category)
	{
		testcase=report.startTest(testcaseName, testDescription);
		testcase.assignAuthor(author);
		testcase.assignCategory(category);
	}
	public void logStep(String status,String desc)
	{
		if(status.equalsIgnoreCase("pass")){
		testcase.log(LogStatus.PASS, desc);		
		}else if(status.equalsIgnoreCase("fail")){
			testcase.log(LogStatus.FAIL, desc);
			throw new RuntimeException();
		}else if(status.equalsIgnoreCase("warning")){
			testcase.log(LogStatus.WARNING, desc);
			throw new RuntimeException();
		}
	}
	public void closeTestReport()
	{
		report.endTest(testcase);
	}
	public void saveReport()
	{
		report.flush();
	}
	
	
	
	/*@Test
	public void extentReports()
	{
		
		ExtentReports report=new ExtentReports("./report/report.html", false);		
		report.loadConfig(new File("./report-config.xml"));		
		ExtentTest testcase=report.startTest("Login");
		testcase.assignAuthor("Anvar");
		testcase.assignCategory("sanity");
		testcase.log(LogStatus.PASS, "success");		
		report.endTest(testcase);
		report.flush();		
		
	}*/	
}
