package com.selenium.base;

import java.io.FileInputStream;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseWeb {

	public WebDriver driver;
	public Properties property;
	public Map<Integer, Object[]> itemMap = new LinkedHashMap<Integer, Object[]>();

	public void invokeBrowser(String browserName) {
		if (property == null) {
			property = new Properties();
			try {
				FileInputStream file = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\ObjectRepository\\config.properties");
				property.load(file);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		try {
			if (property.getProperty(browserName).equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				driver = new ChromeDriver(options);

			} else if (property.getProperty(browserName).equalsIgnoreCase("Opera")) {
				System.setProperty("webdriver.opera.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\operadriver.exe");
				driver = new OperaDriver();
			} else if (property.getProperty(browserName).equalsIgnoreCase("Edge")) {
				System.setProperty("webdriver.edge.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\msedgedriver.exe");
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--disable-notifications");
				driver = new EdgeDriver(options);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	// Open the website URL
	public void openUrl(String urlKey) {
		try {
			System.out.println("Opening the Nykaa Fashion Website");
			driver.get(property.getProperty(urlKey));
			System.out.println("Successfully opened the Nykaa Fashion Website");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void closeBrowser() {
		driver.close();
	}

	// Quit the browser
	public void quitBrowser() {
		driver.quit();
	}

	// Verify the page title
	public void verifyPageTitle(String pageTitle) {
		try {
			String actualTite = driver.getTitle();
			if (pageTitle.equals(actualTite))
				System.out.println("Successfully verified the page title");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Get the element using locators
	public WebElement getElement(String locatorKey) {
		WebElement element = null;
		try {
			if (locatorKey.endsWith("_xpath")) {
				element = driver.findElement(By.xpath(property.getProperty(locatorKey)));
			} else if (locatorKey.endsWith("_className")) {
				element = driver.findElement(By.className(property.getProperty(locatorKey)));
			} else
				System.out.println("Invalid Locator: " + locatorKey);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return element;
	}

	// Enter text in the textfields
	public void enterText(String locatorKey, String data) {
		try {
			getElement(locatorKey).sendKeys(data);
			System.out.println(data + " entered successfully in locator " + locatorKey);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// Using the ENTER key
	public void enterKeys(String locatorKey, Keys keys) {
		try {
			getElement(locatorKey).sendKeys(keys);
			System.out.println("Key entered successfully in locator " + locatorKey);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Click the element
	public void click(String locatorKey) {
		try {
			getElement(locatorKey).click();
			System.out.println(locatorKey + " button clicked successfully");
		} catch (Exception e) {
			e.getMessage();
		}

	}

	// Clear the textfields
	public void clearText(String locatorKey) {
		try {
			getElement(locatorKey).clear();
			System.out.println(locatorKey + " cleared successfully");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Scroll the page to view the action
	public void scrollWebpage(String locatorKey) {
		try {
			WebElement element = getElement(locatorKey);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Store and Print the brand, name and price of the item
	public void storeElements(String locatorKey1, String locatorKey2, String locatorKey3, String locatorKey4) {
		try {
			List<WebElement> brandElement = driver.findElements(By.xpath(property.getProperty(locatorKey1)));
			List<WebElement> nameElement = driver.findElements(By.xpath(property.getProperty(locatorKey2)));
			List<WebElement> priceElement = driver.findElements(By.xpath(property.getProperty(locatorKey3)));
			String rupee = getElement(locatorKey4).getText();
			System.out.println("\nFive Most Popular Headphones in the Range 700-1400 From Nykaa Fashion:");
			for (int i = 0; i < 5; i++)
				System.out.println(brandElement.get(i).getText() + " " + nameElement.get(i).getText() + " "
						+ priceElement.get(i).getText().replaceAll(rupee, "Rs."));

			itemMap.put(0, new Object[] { "ItemBrand", "ItemName", "ItemPrice" });
			for (int i = 1, j = 0; i <= 5 && j < 5; i++, j++)
				itemMap.put(i, new Object[] { brandElement.get(j).getText(), nameElement.get(j).getText(),
						priceElement.get(j).getText() });
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Wait for arribute to change
	public void waitForSlider(String locatorKey, String attribute, String text) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.attributeToBe(By.xpath(property.getProperty(locatorKey)), attribute, text));
			System.out.println("Attribute with locator " + locatorKey + " has " + text);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// Wait for element to be present
	public void waitForElement(String locatorKey, String text) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.textToBePresentInElement(getElement(locatorKey), text));
			System.out.println("Element with locator " + locatorKey + " has text " + text);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Wait for button to click
	public void waitforButton(String locatorKey) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(getElement(locatorKey)));
			System.out.println("Element with locator " + locatorKey + " can be clicked");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
