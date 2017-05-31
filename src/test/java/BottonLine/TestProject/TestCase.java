package BottonLine.TestProject;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;

public class TestCase extends TestBase {

	@BeforeTest
	public void initLogs() throws FileNotFoundException {
		// initLogs(this.getClass());
		init();
	}

	@Test
	public void AddAcounttest() {
		/* Open Browser */
		openBrowser(prop.getProperty("browserType"));
		
		/* Navigate to the Website */
		navigate("testsiteURL");
		
		/* Enter Login User Email */
		input("hp_LoginEmail_Selector", "admin@phptravels.com");
		
		/* Enter your Login Password */
		input("hp_LoginPassword_Selector", "demoadmin");

		/* Click on Login Button */
		click("hp_LoginButton_Selector");

		/*
		 * Wait for Account link within the DashBoard Menu to be displayed and
		 * Click
		 */
		WebDriverWait wait = new WebDriverWait(d, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='#ACCOUNTS']")));
		click("dashBoard_AccountLink_Selector");
		
		/* Click on the Admin link within the Account dropdown */
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("ul#Accounts a[href='http://www.phptravels.net/admin/accounts/admins/']")));
		click("dashBoardAccount_AdminLink_Selector");
		
		/* Click on Add button */
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form.add_button .btn-success")));		
		click("adminManagement_AddButton_Selector");
		
		/* Enter your First Name */
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='fname']")));	
		input("admin_AddFirstName_Selector","Ladibug");
		
		/* Enter Your LastName */
		input("admin_AddLastName_Selector","Ladibugooo");
	
		/* Enter Your Email address */
		input("admin_AddEmail_Selector","test107@phptravels.com");
		
		/* Enter your Password */
		input("admin_AddPassWord_Selector","demoadmin");
		
		/* Enter your Mobile Number */
		input("admin_AddMobileNumber_Selector","0207000100");
	
		/* Select your Country */
		String Country = "GB";
		String Xpath_Menu = "//select[@name='country']//option[@value='{0}']";
		Xpath_Menu = Xpath_Menu.replace("{0}", String.valueOf(Country));
		clickByXpath(Xpath_Menu);
		
		/* Enter your House address */
		input("admin_AddAddressNumber_Selector", "20");
		
		/* Enter your Street Address */
		input("admin_AddAddressStreet_Selector","Soolooonnana");
		
		/* Click on the Tour Check Box on Add Tours*/
		WebElement CheckBox=d.findElement(By.cssSelector("#content > form > div > div.panel-body > div > div.row > div:nth-child(1) > div > div.panel-body > ul > li:nth-child(3) > label > div > ins"));
		((JavascriptExecutor) d).executeScript("arguments[0].click();",CheckBox);
		//click("admin_AddTours_Selector");
		
		/* click Submit button */
		click("admin_Submit_Selector");
		
		/* Verify if Element is present*/
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='mailto:test107@phptravels.com']")));
		 boolean NewAccountHolderEmail=	isElementPresent("AcountHolder_Email_Selector");
		System.out.println(NewAccountHolderEmail);
		
		/* click on edit button*/
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='Edit']")));
		click("AccountHolder_EditInfoButton_Selector");
		
		/* Verify if the AddTour Check box is Checked */
		WebElement AddToursChecked=d.findElement(By.cssSelector("div.checked"));
		wait.until(ExpectedConditions.visibilityOf(AddToursChecked));
		AddToursChecked.isDisplayed();
		Assert.assertTrue(AddToursChecked.isDisplayed());
	

	}

}
