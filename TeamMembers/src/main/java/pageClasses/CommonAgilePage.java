package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;
import sun.jvm.hotspot.runtime.StaticBaseConstructor;

public class CommonAgilePage extends PageBaseClass{
	
	public CommonAgilePage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	
	@FindBy(id = "LOCK_Plan")
	public WebElement plan;
	
	@FindBy(id = "LOCK_Team_Members")
	public WebElement teamMember;
	
	@FindBy(className = "ellipsis")
	public static WebElement userName;
	
	public static String currentUser() {
		return userName.getText();
	}
	
	public TeamMemberPage clickTeamMember() {
		logger.log(Status.INFO, "Clicking Team Member from the drop down");
		hoverOverElement(plan);
		waitForPresence(By.id("LOCK_Plan"));
		teamMember.click();
		logger.log(Status.PASS, "Clicked on Team Member");
		TeamMemberPage teamMemberPage = new TeamMemberPage(driver, logger);
		PageFactory.initElements(driver, teamMemberPage);
		return teamMemberPage;
	}
	

}
