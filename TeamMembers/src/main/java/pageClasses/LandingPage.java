package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;

public class LandingPage extends PageBaseClass {

	public LandingPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}

	@FindBy(xpath = "//input[@class='form-control ltr_override input ext-input text-box ext-text-box' and @name='loginfmt']")
	public WebElement emailField;

	@FindBy(xpath = "//input[@class='form-control input ext-input text-box ext-text-box' and @name='passwd']")
	public WebElement passwordField;

	@FindBy(xpath = "//input[@id='idSubmit_SAOTCC_Continue' and @type='submit']")
	public WebElement verifyButton;

	@FindBy(xpath = "//input[@type='submit' and @id='idSIButton9']")
	public WebElement yesButton;

	public MainPage enterCredentials() {
		logger.log(Status.INFO, "Logging in");
		emailField.click();
		emailField.sendKeys("" + "\n"); //Enter your EmailID
		passwordField.click();
		passwordField.sendKeys("" + "\n"); //Enter your password
		//Enter the code and press enter
		waitForClickable(By.xpath("//input[@type='submit' and @id='idSIButton9']")); //Wait for the page to display yes button
		yesButton.click(); //Click on Yes
		logger.log(Status.PASS, "Logged in");
		MainPage mainPage = new MainPage(driver, logger);
		PageFactory.initElements(driver, mainPage);
		return mainPage;
	}

}
