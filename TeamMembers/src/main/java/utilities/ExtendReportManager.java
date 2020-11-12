package utilities;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportManager{
	
		public static ExtentReports report;
		public static WebDriver driver;
		
		public static ExtentReports getReportInstance(){
			
			if(report == null){
				String reportName = "Arundathi Gopal" + ".html";
				ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/testOutput/" + reportName);
				report =  new ExtentReports();
				report.attachReporter(htmlReporter);
				
				report.setSystemInfo("OS", "Windows 10");
				report.setSystemInfo("Environment", "UAT");
				report.setSystemInfo("Version", "10.0");
				report.setSystemInfo("Browser", "Chrome");
				
				htmlReporter.config().setDocumentTitle("MainSpring Team Members Module Testing");
				htmlReporter.config().setReportName("Hackathon Group 4 Test Crew");
				htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
			}
			
			return report;
		}

}