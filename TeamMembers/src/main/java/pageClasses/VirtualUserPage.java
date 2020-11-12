package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import baseClasses.PageBaseClass;

public class VirtualUserPage extends PageBaseClass{
	public VirtualUserPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	
	@FindBy(id = "contentframe")
	public WebElement virtualFrame;
	
	@FindBy(linkText = "Team Members")
	public WebElement teamMembersButton;
	
	public void goToVirtualUserFrame() {
		driver.switchTo().frame(virtualFrame);
		getTitle("Virtual User");
	}
	
	public TeamMemberPage navigateBack() {
		driver.switchTo().parentFrame();
		waitForClickable(By.linkText("Team Members"));
		teamMembersButton.click();
		TeamMemberPage teamMemberPage = new TeamMemberPage(driver, logger);
		PageFactory.initElements(driver, teamMemberPage);
		return teamMemberPage;
	}
}
