package main.java;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.utils.TestUtils;

public class StepDefenitionOther {
	
	String assetName = "responsive-rect.muse";
	String assetNameTitle = assetName.split("\\.")[0];
	String url = "http://localhost:33333/Preview/"+assetNameTitle+"/index.html";
	String asset = "assets/"+assetName;
	
	String tempFolder = "c:/temp/";
	
	String outFolder = tempFolder+"current/";
	String outHTML = outFolder+ "source.html";
	String outFullCSS = outFolder+ "source.css";
	String outMaxBPCSS = outFolder+"MaxBPCSS.txt";
	String out640BPCSS = outFolder+"640BPCSS.txt";
	String out960BPCSS = outFolder+"960BPCSS.txt";
	
	String baselineFolder = tempFolder+"baselines/";
	String baselineHTML = baselineFolder+ "source.html";
	String baselineFullCSS = baselineFolder+ "source.css";
	String baselineMaxBPCSS = baselineFolder+"MaxBPCSS.txt";
	String baseline640BPCSS = baselineFolder+"640BPCSS.txt";
	String baseline960BPCSS = baselineFolder+"960BPCSS.txt";
	
	String museApp = "C:\\Adobe Muse CC 2018\\Muse.exe";
	
	public static WebDriver driver;
	TestUtils util = new TestUtils();
	
	@When("^User has selected \"([^\"]*)\" browser$")
	public void user_opens_browser(String str) throws Throwable{
		System.out.println(str);
		if(str.toLowerCase().contains("chrome")) {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if(str.toLowerCase().contains("firefox")) {
			driver = new FirefoxDriver();
		}
		else
		{
			// default
			driver = new ChromeDriver();
		}
		
	}
	
	@When("^User enters URL as \"([^\"]*)\"$")
	public void user_enters_url(String url) throws Throwable{
		driver.get(url);
	}
	
	@Then("^Check that \"([^\"]*)\" is in browser title$")
	public void check_website_has_launched(String title) {
		String runTimeTitle = driver.getTitle();
		boolean res = false;
		if(runTimeTitle.contains(title)) {
			res = true;
		}
		assertEquals(res, true);
	}
	
	@Then("^Find Element with id = \"([^\"]*)\" on the page$")
	public void find_element_with_id_on_page(String id) throws Throwable{
		driver.findElement(By.id(id));
	}
	
	@Then("^Close open browser$")
	public void cleanup() {
		driver.close();
		driver.quit();
	}

	@Given("^Launch Muse and Export for asset = \"([^\"]*)\"$")
	public void launch_muse_and_export(String assetName) throws IOException, InterruptedException, AWTException {
		util.launchMuseAssetAndExport(museApp, assetName);
	}
	
	@Given("^Launch Muse and Export for default asset $")
	public void launch_muse_and_export() throws IOException, InterruptedException, AWTException {
		util.launchMuseAssetAndExport(museApp, asset);
	}
	
	@Then("^Maximize browser window$")
	public void maximize_browser_window() {
		driver.manage().window().maximize();;
	}
	
	@Then("^User opens url for asset = \"([^\"]*)\"$")
	public void open_url_for_asset_name(String assetName) {
		String url = "http://localhost:33333/Preview/"+assetName.split("\\.")[0]+"/index.html";
		 driver.get(url);
		 driver.navigate().refresh();
	}
	
	@Then("^User opens url for default asset$")
	public void open_url_for_default_asset() {
		driver.get(url);
		driver.navigate().refresh();
	}

}
