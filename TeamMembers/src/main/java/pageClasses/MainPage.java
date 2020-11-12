package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;

public class MainPage extends PageBaseClass {

	public MainPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}

	@FindBy(className = "left_menu_icon_overlay")
	public WebElement sliderMenu;

	@FindBy(xpath = "//li[@id='projectIcon']/descendant::a[2]")
	public WebElement commonAgileProject;

	public CommonAgilePage clickProjectName() {
		logger.log(Status.INFO, "Clicking the Project Name from the slider menu");
		hoverOverElement(sliderMenu);
		waitForPresence(By.xpath("//li[@id='projectIcon']/descendant::a[2]"));
		commonAgileProject.click();
		logger.log(Status.PASS, "Clicked on Project Name");
		CommonAgilePage commonAgilePage = new CommonAgilePage(driver, logger);
		PageFactory.initElements(driver, commonAgilePage);
		return commonAgilePage;
	}

}