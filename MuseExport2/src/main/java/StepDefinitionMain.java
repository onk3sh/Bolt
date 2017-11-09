package main.java;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

import main.java.utils.DataWebElement;

public class StepDefinitionMain {
	
	@Before
	public void before() {
		
	}
	
	@After
	public void after() {
		
	}
	
	@Given("^Compare sites from URL1 = \"([^\"]*)\" and URL2 = \"([^\"]*)\" using Java$")
	public void compare_two_url_css_specifc(String URL1, String URL2){
		
		WebDriver driver1 = new ChromeDriver();
		driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver1.get(URL1);

		List<String> bpListURL = getBPValuesFromURL(driver1.findElements(By.xpath("//*[@id]")));
		ArrayList<DataWebElement> url1Data = resizeBrowserAndGetElementValues(driver1, bpListURL, URL1);
		
		driver1.quit();
		
		WebDriver driver2 = new ChromeDriver();
		driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver2.get(URL2);

		List<String> bpListURL2 = getBPValuesFromURL(driver2.findElements(By.xpath("//*[@id]")));
		ArrayList<DataWebElement> url2Data = resizeBrowserAndGetElementValues(driver2, bpListURL2, URL2);

		Iterator<DataWebElement> it1 = url1Data.iterator();
		Iterator<DataWebElement> it2 = url2Data.iterator();
		
		while(it1.hasNext() && it2.hasNext()) {
			
			DataWebElement d1 = it1.next();
			DataWebElement d2 = it2.next();
			
			
			System.out.println("---------------Validating element:"+d1.getID()+" at BP:"+d1.getBP()+"----------------------");
				if(d1.getBP().equals(d2.getBP()) && d1.getID().equals(d2.getID())) {
				assertEquals(d1.getWidth(), d2.getWidth());
				assertEquals(d1.getMarginLeft(), d2.getMarginLeft());
				assertEquals(d1.getPerspectiveOrigin(), d2.getPerspectiveOrigin());
			}
		}
		
		driver2.quit();		
	}

	@Given("^Compare sites from URL1 = \"([^\"]*)\" and URL2 = \"([^\"]*)\" using Java for WebElementID =\"([^\"]*)\"$")
	public void compare_two_url_css_specifc(String URL1, String URL2, String WebElementID){
		WebDriver driver1 = new ChromeDriver();
		driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver1.get(URL1);

		List<String> bpListURL = getBPValuesFromURL(driver1.findElements(By.xpath("//*[@id]")));
		ArrayList<DataWebElement> url1Data = resizeBrowserAndGetSingleElementValues(driver1, bpListURL, WebElementID);
		
		driver1.quit();
		
		WebDriver driver2 = new ChromeDriver();
		driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver2.get(URL2);

		List<String> bpListURL2 = getBPValuesFromURL(driver2.findElements(By.xpath("//*[@id]")));
		ArrayList<DataWebElement> url2Data = resizeBrowserAndGetElementValues(driver2, bpListURL2, WebElementID);

		Iterator<DataWebElement> it1 = url1Data.iterator();
		Iterator<DataWebElement> it2 = url2Data.iterator();
		
		while(it1.hasNext() && it2.hasNext()) {
			
			DataWebElement d1 = it1.next();
			DataWebElement d2 = it2.next();
			
			
			System.out.println("---------------Validating element:"+d1.getID()+" at BP:"+d1.getBP()+"----------------------");
				if(d1.getBP().equals(d2.getBP()) && d1.getID().equals(d2.getID())) {
				assertEquals(d1.getWidth(), d2.getWidth());
				assertEquals(d1.getMarginLeft(), d2.getMarginLeft());
				assertEquals(d1.getPerspectiveOrigin(), d2.getPerspectiveOrigin());
			}
		}
		
		driver2.quit();		
	}
	
	public void getAllDataForURL(String URL, ArrayList<DataWebElement> urlData) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(URL);

		List<String> bpListURL = getBPValuesFromURL(driver.findElements(By.xpath("//*[@id]")));
		urlData = resizeBrowserAndGetElementValues(driver, bpListURL, URL);
		
		driver.quit();
	}

	public ArrayList<DataWebElement> resizeBrowserAndGetElementValues(WebDriver driver, List<String> bpListURL, String URL) {
		driver.navigate().refresh();
		ArrayList<DataWebElement> urlData = new ArrayList<DataWebElement>();
		for(String bp : bpListURL) {
			if(bp.contains("infinity")) {
				driver.manage().window().maximize();
			}
			else {
				Integer value = Integer.parseInt(bp.replace("bp_", ""));
				Dimension dimension= new Dimension(value, 1000);
				driver.manage().window().setSize(dimension);
			}
			
			List<WebElement> elementsURL = getElementsFromURL(driver, URL);
			
			for(WebElement e: elementsURL) {
				DataWebElement data = new DataWebElement();
				if(e.getAttribute("id").contains("u")) {
					data.setID(e.getAttribute("id"));
					data.setWidth(e.getCssValue("width"));
					data.setMarginLeft(e.getCssValue("margin-left"));
					data.setPerspectiveOrigin(e.getCssValue("perspective-origin"));
					data.setBP(bp);
					urlData.add(data);
				}
			}
		}
		
		return urlData;
	}
	
	//Method to take element ID directly and return data
	public ArrayList<DataWebElement> resizeBrowserAndGetSingleElementValues(WebDriver driver, List<String> bpListURL, String WebElementID) {
		driver.navigate().refresh();
		ArrayList<DataWebElement> urlData = new ArrayList<DataWebElement>();
		for(String bp : bpListURL) {
			if(bp.contains("infinity")) {
				driver.manage().window().maximize();
			}
			else {
				Integer value = Integer.parseInt(bp.replace("bp_", ""));
				Dimension dimension= new Dimension(value, 1000);
				driver.manage().window().setSize(dimension);
			}
			
			WebElement e = driver.findElement(By.id(WebElementID));
			
			DataWebElement data = new DataWebElement();
			data.setID(e.getAttribute("id"));
			data.setWidth(e.getCssValue("width"));
			data.setMarginLeft(e.getCssValue("margin-left"));
			data.setPerspectiveOrigin(e.getCssValue("perspective-origin"));
			data.setBP(bp);
			urlData.add(data);
		}
		
		return urlData;
	}

	public List<String> getBPValuesFromURL(List<WebElement> url1) {
		List<String> bpListURL = new ArrayList<String>();
		
		for(WebElement e: url1) {
			String s = e.getAttribute("id");
			if(s.contains("bp")) {
				bpListURL.add(s);
			}
		}
		return bpListURL;
	}
	
	public List<WebElement> getElementsFromURL(WebDriver driver, String URL) {
		
		driver.get(URL);

		List<WebElement> url = driver.findElements(By.xpath("//*[@id]"));
		List<WebElement> elementListURL = new ArrayList<WebElement>();
		
		for(WebElement e: url) {
			String s = e.getAttribute("id");
			if(!(s.contains("bp"))) {
				elementListURL.add(e);
			}
		}
		return elementListURL;
	}
}
