package baseClasses;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pageClasses.LandingPage;
import utilities.ExtendReportManager;

public class BaseTestClass {

	public ExtentReports report = ExtendReportManager.getReportInstance();
	public ExtentTest logger;
	public Properties property;
	public RemoteWebDriver driver;
	DesiredCapabilities capabilities = null;

	/****************** Invoke Browser ***********************/
	public void invokeBrowser() {
		if (property == null) {
			property = new Properties();
			try {
				FileInputStream file = new FileInputStream(
						System.getProperty("user.dir") + "\\resources\\objectRepository\\config.properties");
				property.load(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		try {

			if (property.getProperty("browserName").equalsIgnoreCase("Chrome")) {
				capabilities = DesiredCapabilities.chrome();
				/*
				 * System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
				 * + "\\resources\\drivers\\chromedriver.exe"); ChromeOptions options = new
				 * ChromeOptions(); options.addArguments("--disable-notifications"); driver =
				 * new ChromeDriver(options);
				 */
			} else if (property.getProperty("browserName").equalsIgnoreCase("Mozilla")) {
				capabilities = DesiredCapabilities.firefox();
				/*
				 * System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +
				 * "\\resources\\drivers\\geckodriver.exe"); FirefoxOptions options = new
				 * FirefoxOptions(); options.addPreference("dom.webnotifications.enabled",
				 * false); driver = new FirefoxDriver(options);
				 */
			} else if (property.getProperty("browserName").equalsIgnoreCase("Opera")) {
				capabilities = DesiredCapabilities.operaBlink();
				/*
				 * System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") +
				 * "\\resources\\drivers\\operadriver.exe"); driver = new OperaDriver();
				 */
			} else if (property.getProperty("browserName").equalsIgnoreCase("Edge")) {
				capabilities = DesiredCapabilities.edge();
				/*
				 * System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +
				 * "\\resources\\drivers\\msedgedriver.exe"); driver = new EdgeDriver();
				 */
			}
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	/****************** OpenApplication ***********************/
	public LandingPage OpenApplication() {
		logger.log(Status.INFO, "Opening the WebSite");
		driver.get(property.getProperty("url"));
		logger.log(Status.PASS, "Successfully Opened the PolicyBazaar Website");
		LandingPage landingPage = new LandingPage(driver, logger);
		PageFactory.initElements(driver, landingPage);
		return landingPage;
	}

	@AfterMethod
	public void closeBrowser() {
		report.flush();
		driver.close();
	}

}