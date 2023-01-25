package baseClasses;

import java.io.File;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.DateUtil;

public class PageBaseClass extends BaseTestClass {

	public ExtentTest logger;
	public SoftAssert softAssert = new SoftAssert();

	public PageBaseClass(RemoteWebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}
		
	/****************** Get Page Title ***********************/
	public void getTitle(String expectedTitle) {
		try {
			Assert.assertEquals(driver.getTitle(), expectedTitle);
			reportPass("Actual Title : " + driver.getTitle() + " - equals to Expected Title : " + expectedTitle);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}
	
	/****************** Verify Error Message ***********************/
	public void getErrorMessage(String ActualError, String expectedError) {
		try {
			
			softAssert.assertEquals(ActualError, expectedError);
			reportPass("ActualError : " + ActualError + " - equals to Expected Error : " + expectedError);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}
	
	/****************** Select value From DropDown ***********************/
	public void selectDropDownValue(WebElement webElement, String value){
		try {
			Select select = new Select(webElement);
			select.selectByValue(value);
			logger.log(Status.PASS, "Selected the Value : " + value);
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	/****************** Get The Drop Down Menu By Hovering ***********************/
	public void hoverOverElement(WebElement webElement) {
		Actions action = new Actions(driver);
		action.moveToElement(webElement).build().perform();
	}
	

	/****************** Reporting Functions ***********************/
	public void reportFail(String reportString) {
		logger.log(Status.FAIL, reportString);
		takeScreenShotOnFailure();
		Assert.fail(reportString);
	}

	public void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);
	}

	/****************** Capture Screen Shot ***********************/
	public void takeScreenShotOnFailure() {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);

		File destFile = new File(System.getProperty("user.dir") + "/ScreenShots/" + DateUtil.getTimeStamp() + ".png");
		try {
			FileUtils.copyFile(sourceFile, destFile);
			logger.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "/ScreenShots/" + DateUtil.getTimeStamp() + ".png");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void waitForPresence(By by) {
		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		wait1.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	public void selectDateIncalendar(String date, WebElement webElement1, WebElement webElement2, WebElement webElement3, WebElement webElement4) {

		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date expectedDate = dateFormat.parse(date);

			String day = new SimpleDateFormat("dd").format(expectedDate);
			String month = new SimpleDateFormat("MMM").format(expectedDate);
			String year = new SimpleDateFormat("yyyy").format(expectedDate);
			while (true) {
				Select selectMonth = new Select(webElement1);
				String displayMonth = selectMonth.getFirstSelectedOption().getText();
				Select selectYear = new Select(webElement2);
				String displayYear= selectYear.getFirstSelectedOption().getText();
				if (month.equals(displayMonth) && year.equals(displayYear)) {
					driver.findElement(By.xpath("//td[text()= '" + day + "']")).click();
					break;
				} else if (expectedDate.compareTo(currentDate) > 0) {
					webElement3.click();
				} else {
					webElement4.click();
				}

			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
		
		public void selectDateIncalendar2(String date, WebElement webElement1, WebElement webElement2, WebElement webElement3, WebElement webElement4) {
			Date currentDate = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date expectedDate = dateFormat.parse(date);

				String day = new SimpleDateFormat("dd").format(expectedDate);
				String month = new SimpleDateFormat("MMM").format(expectedDate);
				String year = new SimpleDateFormat("yyyy").format(expectedDate);
				while (true) {
					Select selectMonth = new Select(driver.findElement(By.xpath("//*[@id='navigatorType']/body/div[7]/div[2]/div[1]/table/thead/tr[1]/th[2]/select[1]")));
					String displayMonth = selectMonth.getFirstSelectedOption().getText();
					Select selectYear = new Select(driver.findElement(By.xpath("//*[@id='navigatorType']/body/div[7]/div[2]/div[1]/table/thead/tr[1]/th[2]/select[2]")));
					String displayYear= selectYear.getFirstSelectedOption().getText();
					if (month.equals(displayMonth) && year.equals(displayYear)) {
						driver.findElement(By.xpath("//*[@id='navigatorType']/body/div[7]/div[2]/div[1]//td[text()= '" + day + "']")).click();
						break;
					} else if (expectedDate.compareTo(currentDate) > 0) {
						driver.findElement(By.xpath("//*[@id='navigatorType']/body/div[7]/div[2]/div[1]/table/thead/tr[1]/th[3]")).click();
					} else {
						driver.findElement(By.xpath("//*[@id='navigatorType']/body/div[7]/div[2]/div[1]/table/thead/tr[1]/th[1]")).click();
					}

				}

			} catch (ParseException e) {
				e.printStackTrace();
			}

	}

}
