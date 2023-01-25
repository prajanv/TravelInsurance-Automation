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

public class SelectRtoPage extends PageBaseClass{
	
	public SelectRtoPage(RemoteWebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	
	@FindBy(id = "spn4")
	public WebElement cityName;
	
	@FindBy(xpath = "//div[@id='section2']/descendant::span[2]")
	public WebElement cityRto;
	
	public SelectCarBrandPage selectCityRto() {
		waitForPresence(By.id("spn4"));
		cityName.click();
		logger.log(Status.PASS, "Selected the City");
		cityRto.click();
		logger.log(Status.PASS, "Selected the RTO");
		SelectCarBrandPage selectCarBrandPage = new SelectCarBrandPage(driver, logger);
		PageFactory.initElements(driver,selectCarBrandPage);
		return selectCarBrandPage;
	}

}
