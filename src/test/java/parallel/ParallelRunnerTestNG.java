package parallel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.qa.util.ConfigReader;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/parallel/LoginPage.feature"},		
		monochrome = true,
		glue = {"parallel"},
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"
				},
//		tags = "not @Skip",
		publish = true,
		dryRun = false
		)
public class ParallelRunnerTestNG extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
//	@BeforeClass
	public void setReportDate() {
		ConfigReader confReader = new ConfigReader();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MMM_yyyy_HH_mm_ss");
		LocalDateTime now = LocalDateTime.now();
		String strDate = dtf.format(now);
		String reportName = "test-output/SparkReport/ExtentReport_"+strDate +".html";//test-output/SparkReport/Spark.html
		System.out.println(reportName);
		confReader .writeToExtentProperty("extent.reporter.spark.out", reportName);
	}
	
}
