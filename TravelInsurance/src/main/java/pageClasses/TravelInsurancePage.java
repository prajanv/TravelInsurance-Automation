package pageClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;

public class TravelInsurancePage extends PageBaseClass{
	
	public TravelInsurancePage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	
	@FindBy(xpath = "//*[@id=\"topForm\"]/section/div[2]/article/ul/li[3]/a")
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
	public WebElement travellerMail ;
	
	@FindBy(css = "a[class='proceedButton travelproceed']")
	public WebElement getFreeQuotes;
	
	public InsuranceListPage fillDetailsTravel () {
		logger.log(Status.INFO, "Filling Details for Travel Insurance Plans");
		studentTraveller.click();
		destination.sendKeys("Germany"+"\n");
		studentAge1.click();
		studentAge1.sendKeys("22");
		studentAge2.click();
		studentAge2.sendKeys("21");
		calenderLeft.click();
		selectDateIncalendar("10/12/2020", monthLeft , yearLeft, forwardLeft, backwardLeft);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		calenderRight.click();
		selectDateIncalendar2("20/12/2020",monthRight , yearRight,forwardRight, backwardRight);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		medicalCondition.click();
		proceed.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("travelgender")));
		title.click();
		Select selectGender = new Select(title);
		selectGender.selectByValue("2");
		travellerName.sendKeys("Priya");
		travellerPhone.sendKeys("9876543210");
		travellerMail.sendKeys("priya@gmail.com");
		getFreeQuotes.click();
		logger.log(Status.PASS, "Filled Details");
		InsuranceListPage insuranceListPage = new InsuranceListPage(driver, logger);
		PageFactory.initElements(driver, insuranceListPage);
		return insuranceListPage;
	}
}
