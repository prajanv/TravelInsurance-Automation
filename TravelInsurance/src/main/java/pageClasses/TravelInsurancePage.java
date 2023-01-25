package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;

public class TravelInsurancePage extends PageBaseClass{
	
	public TravelInsurancePage(RemoteWebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	
	@FindBy(xpath = "//*[@id='topForm']/section/div[2]/article/ul/li[3]/a")
	public WebElement studentTraveller;
	
	@FindBy(xpath = "//*[@id='destination-autocomplete']")
	public WebElement destination;
	
	@FindBy(xpath = "//*[@id='memage1']")
	public WebElement studentAge1;
	
	@FindBy(xpath = "//*[@id='memage2']")
	public WebElement studentAge2;
	
	@FindBy(id = "startdate")
	public WebElement calenderLeft;
	
	@FindBy(className = "monthselect")
	public WebElement monthLeft;
	
	@FindBy(className = "yearselect")
	public WebElement yearLeft;
	
	@FindBy(xpath = "//*[@id='navigatorType']/body/div[6]/div[2]/div[1]/table/thead/tr[1]/th[3]")
	public WebElement forwardLeft;

	@FindBy(xpath = "//*[@id='navigatorType']/body/div[6]/div[2]/div[1]/table/thead/tr[1]/th[1]")
	public WebElement backwardLeft;
	
	@FindBy(id = "enddate")
	public WebElement calenderRight;
	
	@FindBy(xpath="//*[@id='navigatorType']/body/div[7]/div[2]/div[1]/table/thead/tr[1]/th[2]/select[1]")
	public WebElement monthRight;
	
	@FindBy(xpath = "//*[@id='navigatorType']/body/div[7]/div[2]/div[1]/table/thead/tr[1]/th[2]/select[2]")
	public WebElement yearRight;
	
	@FindBy(xpath = "//*[@id='navigatorType']/body/div[7]/div[2]/div[1]/table/thead/tr[1]/th[3]")
	public WebElement forwardRight;

	@FindBy(xpath = "//*[@id='navigatorType']/body/div[7]/div[2]/div[1]/table/thead/tr[1]/th[1]")
	public WebElement backwardRight;
	
	@FindBy(xpath = "//*[@id='isPED']/div/label[2]")
	public WebElement medicalCondition;
	
	@FindBy(id = "proceedStepOne")
	public WebElement proceed;
	
	@FindBy(id = "travelgender")
	public WebElement title;
	
	@FindBy(id = "travelname")
	public WebElement travellerName;
	
	@FindBy(id = "travelmobile")
	public WebElement travellerPhone;
	
	@FindBy(id = "travelemail")
	public WebElement travellerEmail ;
	
	@FindBy(css = "a[class='proceedButton travelproceed']")
	public WebElement getFreeQuotes;
	
	public InsuranceListPage fillDetailsTravel (String country, String firstAge, String secondAge, String startDate, String endDate, String honorific, String name, String mobileNo, String email) {
		studentTraveller.click();
		destination.sendKeys(country+"\n");
		logger.log(Status.PASS, "Entered the Destination : " + country);
		studentAge1.click();
		studentAge1.sendKeys(firstAge);
		logger.log(Status.PASS, "Entered the Age of First Student : " + firstAge);
		studentAge2.click();
		studentAge2.sendKeys(secondAge);
		logger.log(Status.PASS, "Entered the Age of Second Student : " + secondAge);
		calenderLeft.click();
		selectDateIncalendar(startDate, monthLeft , yearLeft, forwardLeft, backwardLeft);
		logger.log(Status.PASS, "Entered the Start Date of the Trip : " + startDate);
		calenderRight.click();
		selectDateIncalendar2(endDate, monthRight , yearRight,forwardRight, backwardRight);
		logger.log(Status.PASS, "Entered the End Date of the Trip : " + endDate);
		medicalCondition.click();
		logger.log(Status.PASS, "Selected Medical Condition");
		proceed.click();
		logger.log(Status.PASS, "Clicked on Proceed Button");
		waitForPresence(By.id("travelgender"));
		title.click();
		selectDropDownValue(title,honorific);
		travellerName.sendKeys(name);
		logger.log(Status.PASS, "Entered the Name of the Traveller");
		travellerPhone.sendKeys(mobileNo);
		logger.log(Status.PASS, "Entered the Mobile Number of the Traveller");
		travellerEmail.sendKeys(email);
		logger.log(Status.PASS, "Entered the Email ID of the Traveller");
		getFreeQuotes.click();
		logger.log(Status.PASS, "Clicked on Get Free Quotes Button");
		InsuranceListPage insuranceListPage = new InsuranceListPage(driver, logger);
		PageFactory.initElements(driver, insuranceListPage);
		return insuranceListPage;
	}
}
