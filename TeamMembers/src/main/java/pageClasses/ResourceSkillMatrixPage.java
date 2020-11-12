package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import baseClasses.PageBaseClass;

public class ResourceSkillMatrixPage extends PageBaseClass{

	public ResourceSkillMatrixPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	
	@FindBy(linkText = "Team Members")
	public WebElement teamMembersButton;
	
	@FindBy(id = "contentframe")
	public WebElement matrixFrame;
	
	public void goToSkillMatrixFrame() {
		waitForPresence(By.id("contentframe"));
		driver.switchTo().frame(matrixFrame);
		getTitle("Skill Matrix");
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
