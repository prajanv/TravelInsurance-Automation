package pageClasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import baseClasses.PageBaseClass;

public class InsuranceListPage extends PageBaseClass{
	
	public InsuranceListPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	
	@FindBy(xpath = "//div[@class='date_birth']/select[1]")
	public WebElement sumInsured;
	
	@FindBy(xpath = "//div[@class='sort_price']//select")
	public WebElement sortBy;
	
	@FindBy(xpath = "//div[@id='child']/p[1]/img")
	public List <WebElement> insuranceCompany;
	
	@FindBy(xpath = "//div[@id='child']/p[2]/span[1]")
	public List <WebElement> insurancePlan;
	
	@FindBy(xpath = "//div[@id='child']//button[@class='md-button md-default-theme']")
	public List <WebElement> insuranceAmount;

	public void showInsurance () {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='date_birth']/select[1]")));
	
	sumInsured.click();
	Select selectSum = new Select(sumInsured);
	selectSum.selectByValue("50000");
	
	sortBy.click();
	Select selectSort = new Select(sortBy);
	selectSort.selectByVisibleText("Low to High");
	
	for(int i =0; i<3; i++) {
		System.out.println(insuranceCompany.get(i).getAttribute("alt")+" "+insurancePlan.get(i).getText()+" "+insuranceAmount.get(i).getText());
	}
	}
}
