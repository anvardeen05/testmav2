package wrappers;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import utils.Reporter;

public class GenericWrappers extends Reporter implements Wrappers {

	public RemoteWebDriver driver;
	public WebElement elem;
	Select dropDown;
	int i = 1;

	public void invokeApp(String browser, String url) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver_32bit.exe");
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer_32bit.exe");
				driver = new InternetExplorerDriver();
			}
			driver.manage().window().maximize();
			driver.get(url);			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);			
			System.out.println("The browser " + browser + " launched successfully");
			logStep("pass", "Browser is launched successfully");
		} catch (WebDriverException e) {
			System.err.println("Browser is not reachable");
			// include reporter log steps here
			logStep("fail", "Browser is not reachable");
			// throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			logStep("fail", "Browser is not reachable");
			// throw new RuntimeException();
		} finally {
			takeSnap();
		}
	}

	public void enterById(String idValue, String data) {
		try {
			elem = driver.findElementById(idValue);
			elem.clear();
			elem.sendKeys(data);
			System.out.println("The text field with id " + idValue + " entered with data " + data + " successfully.");
			logStep("pass", "The text field with id "+idValue+" entered with data "+data+" successfully.");
		} catch (NoSuchElementException e) {
			System.err.println("The text field with id " + idValue + " is not found");
			logStep("fail", "The text field with id " + idValue + " is not found");
			// throw new RuntimeException();
		} catch (WebDriverException e) {
			System.err.println("The text field with id " + idValue + " is not found");
			logStep("fail", "The text field with id " + idValue + " is not found");
			// throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			logStep("fail", "The text field with id " + idValue + " is not found");
			// throw new RuntimeException();
		} finally {
			takeSnap();
		}
	}

	public void enterByName(String nameValue, String data) {
		try {
			elem = driver.findElementByName(nameValue);
			elem.clear();
			elem.sendKeys(data);
			System.out
					.println("The text field with name " + nameValue + " entered with data " + data + " successfully.");
			logStep("pass", "The text field with name " + nameValue + " entered with data " + data + " successfully.");
		} catch (NoSuchElementException e) {
			System.err.println("The text field with name " + nameValue + " is not found");
			logStep("fail", "The text field with name " + nameValue + " is not found");
			// throw new RuntimeException();
		} catch (WebDriverException e) {
			System.err.println("The text field with name " + nameValue + " is not found");
			logStep("fail", "The text field with name " + nameValue + " is not found");
			// throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			logStep("fail", "The text field with name " + nameValue + " is not found");
			// throw new RuntimeException();
		} finally {
			takeSnap();
		}
	}

	public void enterByXpath(String xpathValue, String data) {
		try {
			elem = driver.findElementByXPath(xpathValue);
			elem.clear();
			elem.sendKeys(data);
			System.out.println(
					"The text field with xpath " + xpathValue + " entered with data " + data + " successfully.");
			logStep("pass", "The text field with xpath " + xpathValue + " entered with data " + data + " successfully.");
		} catch (NoSuchElementException e) {
			System.err.println("The text field with xpath " + xpathValue + " is not found");
			logStep("fail", "The text field with xpath " + xpathValue + " is not found");
			// throw new RuntimeException();
		} catch (WebDriverException e) {
			System.err.println("The text field with xpath " + xpathValue + " is not found");
			logStep("fail", "The text field with xpath " + xpathValue + " is not found");
			// throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			logStep("fail", "The text field with xpath " + xpathValue + " is not found");
			// throw new RuntimeException();
		} finally {
			takeSnap();
		}
	}

	public boolean verifyTitle(String title) {

		try {
			String currentTitle = driver.getTitle();
			if (currentTitle.equalsIgnoreCase(title)) {
				System.out.println("Browser window title " + currentTitle + " matches.");
				logStep("pass", "Browser window title " + currentTitle + " matches.");
				return true;
				
			} else {
				System.err.println("Browser window title " + currentTitle + " does not match the given title " + title);
				logStep("fail", "Browser window title " + currentTitle + " does not match the given title " + title);
				return false;
			}
			
		} catch (WebDriverException e) {
			System.err.println("The given title" + title + "is not found");
			logStep("fail", "The given title" + title + "is not found");
			// throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			logStep("fail", "The given title" + title + "is not found");
			// throw new RuntimeException();
		} finally {
			takeSnap();
		}
		return false;
	}

	public boolean verifyTextById(String idValue, String text) {
		boolean rtnBool = false;
				try {
			elem = driver.findElementById(idValue);
			String elemTxt = elem.getText();			
			if (elemTxt.equalsIgnoreCase(text)) {
				rtnBool = true;
				System.out.println("The text" + elemTxt + "in the field with id " + idValue + " matches.");
				logStep("pass", "The text" + elemTxt + "in the field with id " + idValue + " matches.");
			} else {
				System.err.println("The text" + elemTxt + "in the field with id " + idValue
						+ " does not match with the given text " + text);
			}
		} catch (NoSuchElementException e) {
			System.err.println("The text field with id" + idValue + "is not found");
			logStep("fail", "The text field with id" + idValue + "is not found");
		} catch (WebDriverException e) {
			System.err.println("The text field with id" + idValue + "is not found");
			logStep("fail", "The text field with id" + idValue + "is not found");
		} catch (Exception e) {
			e.printStackTrace();
			logStep("fail", "The text field with id " + idValue + " is not found");
		} finally {
			takeSnap();
		}
		return rtnBool;
	}

	public boolean verifyTextByXpath(String xpath, String text) {
		boolean rtnBool = false;		
		try {
			elem = driver.findElementByXPath(xpath);
			String elemTxt = elem.getText();
			if (elemTxt.equalsIgnoreCase(text)) {
				rtnBool = true;
				System.out.println("The text in " + elemTxt + " the field with xpath " + xpath + " matches.");
			} else {
				System.err.println("The text in " + elemTxt + " the field with xpath " + xpath
						+ " does not match with the given text " + text);
			}
		} catch (NoSuchElementException e) {
			System.err.println("The text field with xpath " + xpath + " is not found");
			logStep("fail", "The text field with xpath " + xpath + " is not found");
		} catch (WebDriverException e) {
			System.err.println("The text field with xpath " + xpath + " is not found");
			logStep("fail", "The text field with xpath " + xpath + " is not found");
			// throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			logStep("fail", "The text field with xpath " + xpath + " is not found");
		} finally {
			takeSnap();
		}
		return rtnBool;
	}

	
	public boolean verifyTextContainsByXpath(String xpath, String text) {
		boolean rtnBool = false;
		try {
			elem = driver.findElementByXPath(xpath);
			String elemTxt = elem.getText();
			if (elemTxt.contains(text)) {
				rtnBool = true;
				System.out.println("The text in " + elemTxt + " the field with xpath " + xpath + " matches.");
			} else {
				System.err.println("The text in " + elemTxt + " the field with xpath " + xpath
						+ " does not match with the given text " + text);
			}
		} catch (NoSuchElementException e) {
			System.err.println("The text field with id " + xpath + " is not found");
		} catch (WebDriverException e) {
			System.err.println("Browser is not reachable");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takeSnap();
		}
		return rtnBool;
	}

	public void clickById(String id) {
		try {
			driver.findElementById(id).click();
			System.out.println("The button with id " + id + " is clicked");
		} catch (NoSuchElementException e) {
			System.err.println("The field with id " + id + " is not found");
			logStep("fail", "The field with id " + id + " is not found");
		} catch (WebDriverException e) {
			System.err.println("The field with id " + id + " is not found");
			logStep("fail", "The field with id " + id + " is not found");
		} catch (Exception e) {
			e.printStackTrace();
			logStep("fail", "The field with id " + id + " is not found");
		} finally {
			takeSnap();
		}
	}

	public void clickByClassName(String classVal) {
		try {
			driver.findElementByClassName(classVal).click();
			System.out.println("The button with class " + classVal + " is clicked");
		} catch (NoSuchElementException e) {
			System.err.println("The field with class name " + classVal + " is not found");
			logStep("fail", "The field with class name " + classVal + " is not found");
		} catch (WebDriverException e) {
			System.err.println("The field with class name " + classVal + " is not found");
			logStep("fail", "The field with class name " + classVal + " is not found");
			// throw new RuntimeException();
		} catch (Exception e) {
			logStep("fail", "The field with class name " + classVal + " is not found");
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}

	public void clickByName(String name) {
		try {
			driver.findElementByName(name).click();
			System.out.println("The button with name " + name + " is clicked");
		} catch (NoSuchElementException e) {
			System.err.println("The field with name " + name + " is not found");
			logStep("fail", "The field with name " + name + " is not found");
		} catch (WebDriverException e) {
			System.err.println("The field with name " + name + " is not found");
			logStep("fail", "The field with name " + name + " is not found");
		} catch (Exception e) {
			logStep("fail", "The field with name " + name + " is not found");
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}

	public void clickByLink(String name) {
		try {
			driver.findElementByLinkText(name).click();
			System.out.println("The button with link text " + name + " is clicked");
		} catch (NoSuchElementException e) {
			System.err.println("The field with link text " + name + " is not found");
			logStep("fail", "The field with name " + name + " is not found");
		} catch (WebDriverException e) {
			System.err.println("The field with link text " + name + " is not found");
			logStep("fail", "The field with link text " + name + " is not found");
			// throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			logStep("fail", "The field with link text " + name + " is not found");
		} finally {
			takeSnap();
		}
	}

	public void clickByLinkNoSnap(String name) {
		try {
			driver.findElementByLinkText(name).click();
			System.out.println("The button with link text " + name + " is clicked");
		} catch (NoSuchElementException e) {
			System.err.println("The field with link text " + name + " is not found");
			logStep("fail", "The field with link text " + name + " is not found");
		} catch (WebDriverException e) {
			System.err.println("The field with link text " + name + " is not found");
			logStep("fail", "The field with link text " + name + " is not found");
		} catch (Exception e) {
			e.printStackTrace();
			logStep("fail", "The field with link text " + name + " is not found");
		}
	}

	public void clickByXpath(String xpathVal) {
		try {
			driver.findElementByXPath(xpathVal).click();
			System.out.println("The button with xpath " + xpathVal + " is clicked");
		} catch (NoSuchElementException e) {
			System.err.println("The field with xpath " + xpathVal + " is not found");
			logStep("fail", "The field with xpath " + xpathVal + " is not found");
		} catch (WebDriverException e) {
			System.err.println("The field with xpath " + xpathVal + " is not found");
			logStep("fail", "The field with xpath " + xpathVal + " is not found");
			// throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			logStep("fail", "The field with xpath " + xpathVal + " is not found");
		} finally {
			takeSnap();
		}
	}

	public void clickByXpathNoSnap(String xpathVal) {
		try {
			driver.findElementByXPath(xpathVal).click();
			System.out.println("The button with xpath " + xpathVal + " is clicked");
		} catch (NoSuchElementException e) {
			System.err.println("The field with xpath " + xpathVal + " is not found");
			logStep("fail", "The field with xpath " + xpathVal + " is not found");
		} catch (WebDriverException e) {
			System.err.println("The field with xpath " + xpathVal + " is not found");
			logStep("fail", "The field with xpath " + xpathVal + " is not found");
		} catch (Exception e) {
			e.printStackTrace();
			logStep("fail", "The field with xpath " + xpathVal + " is not found");
		}
	}

	public String getTextById(String idValue) {
		String rtnTxt = null;
		try {
			elem = driver.findElementById(idValue);
			rtnTxt = elem.getText();
			System.out.println("The text in element with id " + idValue + " is " + rtnTxt);
		} catch (NoSuchElementException e) {
			System.err.println("The text field with id " + idValue + " is not found");
			logStep("fail", "The text field with id " + idValue + " is not found");
		} catch (WebDriverException e) {
			System.err.println("The text field with id " + idValue + " is not found");
			logStep("fail", "The text field with id " + idValue + " is not found");
		} catch (Exception e) {
			e.printStackTrace();
			logStep("fail", "The text field with id " + idValue + " is not found");
		} finally {
			takeSnap();
		}
		return rtnTxt;
	}

	public String getTextByXpath(String xpathVal) {
		String rtnTxt = null;
		try {
			rtnTxt = driver.findElementByXPath(xpathVal).getText();
			System.out.println("Text for the element with xpath " + xpathVal + " is " + rtnTxt);
		} catch (NoSuchElementException e) {
			System.err.println("The text field with xpath " + xpathVal + " is not found");
			logStep("fail", "The text field with xpath " + xpathVal + " is not found");
		} catch (WebDriverException e) {
			System.err.println("Browser is not reachable");
			logStep("fail", "The text field with xpath " + xpathVal + " is not found");
		} catch (Exception e) {
			e.printStackTrace();
			logStep("fail", "The text field with xpath " + xpathVal + " is not found");
		} finally {
			takeSnap();
		}
		return rtnTxt;
	}

	public void selectVisibileTextById(String id, String value) {
		try {
			elem = driver.findElementById(id);
			dropDown = new Select(elem);
			dropDown.selectByVisibleText(value);
			System.out.println("Selected the value " + value + " in the Dropdown field with id " + id + " successfully.");
		} catch (NoSuchElementException e) {
			System.err.println("The Dropdown field with id " + id + " is not found");
			logStep("fail", "The dropdown field with id " + id + " is not found");
		} catch (WebDriverException e) {
			System.err.println("The dropdown field with id " + id + " is not found");
			logStep("fail", "The dropdown field with id " + id + " is not found");
		} catch (Exception e) {
			e.printStackTrace();
			logStep("fail", "The dropdown field with xpath " + id + " is not found");
		} finally {
			takeSnap();
		}
	}

	public void selectIndexById(String id, int value) {
		try {
			elem = driver.findElementById(id);
			dropDown = new Select(elem);
			dropDown.selectByIndex(value);
			System.out.println("Selected the value at index " + String.valueOf(value)
					+ " in the Dropdown field with id " + id + " successfully.");
		} catch (NoSuchElementException e) {
			System.err.println("The Dropdown field with id " + id + " is not found");
			logStep("fail", "The dropdown field with id " + id + " is not found");
		} catch (WebDriverException e) {
			System.err.println("The dropdown field with id " + id + " is not found");
			logStep("fail", "The dropdown field with id " + id + " is not found");
		} catch (Exception e) {
			e.printStackTrace();
			logStep("fail", "The dropdown field with id " + id + " is not found");
		} finally {
			takeSnap();
		}
	}

	public void selectLastIndexById(String id) {
		try {
			elem = driver.findElementById(id);
			dropDown = new Select(elem);
			int ind = dropDown.getOptions().size() - 1;
			dropDown.selectByIndex(ind);
			System.out.println("Selected the last value at index " + String.valueOf(ind)
					+ " in the Dropdown field with id " + id + " successfully.");
		} catch (NoSuchElementException e) {
			System.err.println("The Dropdown field with id " + id + " is not found");
			logStep("fail", "The dropdown field with id " + id + " is not found");
		} catch (WebDriverException e) {
			System.err.println("Browser is not reachable");
			logStep("fail", "The dropdown field with id " + id + " is not found");
		} catch (Exception e) {
			e.printStackTrace();
			logStep("fail", "The dropdown field with id " + id + " is not found");
		} finally {
			takeSnap();
		}
	}

	public void switchToParentWindow() {
		try{
			Set<String> wHandles = driver.getWindowHandles();
			for (String wHandle : wHandles) {
				driver.switchTo().window(wHandle);
				break;
			}			
		}catch (Exception e) {
			System.err.println("The window is not found");
			logStep("fail", "The window is not found");	
		}
		finally {
			takeSnap();
		}
	}

	public void switchToLastWindow() {
		try {
			String currentWinHand = driver.getWindowHandle();
			String currentWinTitle = driver.getTitle();
			Set<String> winHands = driver.getWindowHandles();
			for (String eachWinHand : winHands) {
				if (!currentWinHand.equals(eachWinHand)) {
					driver.switchTo().window(eachWinHand);
				}
			}
			// String newWinHand = driver.getWindowHandle();
			String newWinTitle = driver.getTitle();
			System.out.println("Window handle switched from window with title " + currentWinTitle
					+ " to window with title " + newWinTitle);
			
		} catch (Exception e) {
			System.err.println("The window is not found");
			logStep("fail", "The window is not found");	
		} finally {
			takeSnap();
		}
	}

	public void switchToFrame(String frameName){
		try {
			driver.switchTo().frame(frameName);
			System.out.println("Switched to frame successfully");
			logStep("pass","Switched to frame successfully" +frameName);
		} catch (Exception e) {
			logStep("fail", "There is no such frame to switch over");
		}finally {
			takeSnap();
		}		
	}
	public void acceptAlert() {
		try {
			Alert alrt = driver.switchTo().alert();
			alrt.accept();
			logStep("pass","Accepted the alert successfully");
		} catch (NoAlertPresentException e) {
			System.err.println("The alert did not appear");
			logStep("fail","The alert did not appear");
		}finally{
			takeSnap();
		}
	}

	public void dismissAlert() {
		try {
			Alert alrt = driver.switchTo().alert();
			alrt.dismiss();
		} catch (NoAlertPresentException e) {
			System.err.println("The alert did not appear");			
		}finally{
			takeSnap();
		}
	}

	public String getAlertText() {
		String sText="";
		try {
			Alert alrt=driver.switchTo().alert();
			alrt.getText();
		} catch (NoAlertPresentException e) {
			System.err.println("The alert did not appear");
		}finally{
			takeSnap();
		}
		return sText;
	}

	public void takeSnap() {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./snaps/snap" + i + ".jpg");
		i++;
		try {
			FileUtils.copyFile(src, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void closeBrowser() {
		driver.close();
		System.out.println("The browser is closed");
	}

	public void closeAllBrowsers() {
		System.out.println("Closing all browser windows opened by this session.");
		driver.quit();
	}		
}
