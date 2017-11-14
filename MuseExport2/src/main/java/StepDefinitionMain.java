package main.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import main.java.utils.DataWebElement;

public class StepDefinitionMain {
	
	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	List<String> idList = new ArrayList<String>();
	List<String> BPList = new ArrayList<String>();
	List<String> cssList = new ArrayList<String>();
	
	@Before
	public void before() {
		
	}
	
	@After
	public void after() {
		
	}
	
	@Given("^Compare sites from URL1 = \"([^\"]*)\" and URL2 = \"([^\"]*)\" using Java$")
	public void compare_two_url_css_specifc(String URL1, String URL2) throws InterruptedException{
		
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

		compareDataFromBothURLs(url1Data, url2Data);
		
		driver2.quit();		
	}

	@Given("^Compare sites from URL1 = \"([^\"]*)\" and URL2 = \"([^\"]*)\" using Java for WebElementID = \"([^\"]*)\"$")
	public void compare_two_url_css_specifc(String URL1, String URL2, String WebElementID) throws InterruptedException{
		WebDriver driver1 = new ChromeDriver();
		driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver1.get(URL1);

		List<String> bpListURL = getBPValuesFromURL(driver1.findElements(By.xpath("//*[@id]")));
		ArrayList<DataWebElement> url1Data = resizeBrowserAndGetElementValues(driver1, bpListURL, URL1, WebElementID);
		
		driver1.quit();
		
		WebDriver driver2 = new ChromeDriver();
		driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver2.get(URL2);

		List<String> bpListURL2 = getBPValuesFromURL(driver2.findElements(By.xpath("//*[@id]")));
		ArrayList<DataWebElement> url2Data = resizeBrowserAndGetElementValues(driver2, bpListURL2, URL2, WebElementID);

		compareDataFromBothURLs(url1Data, url2Data);
		
		driver2.quit();		
	}
	
	@Given("^Compare sites from URL1 = \"([^\"]*)\" and URL2 = \"([^\"]*)\" using Java, ALL IDs ALL CSS$")
	public void compare_two_url_all_id_all_css(String URL1, String URL2) throws InterruptedException {
		WebDriver driver1 = new ChromeDriver();
		driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver1.get(URL1);

		List<String> bpListURL = getBPValuesFromURL(driver1.findElements(By.xpath("//*[@id]")));
		ArrayList<DataWebElement> url1Data = resizeBrowserAndGetElementValues(driver1, bpListURL, URL1,true);
		
		driver1.quit();
		
		WebDriver driver2 = new ChromeDriver();
		driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver2.get(URL2);

		List<String> bpListURL2 = getBPValuesFromURL(driver2.findElements(By.xpath("//*[@id]")));
		ArrayList<DataWebElement> url2Data = resizeBrowserAndGetElementValues(driver2, bpListURL2, URL2, true);

		compareDataFromBothURLs(url1Data, url2Data);
		
		driver2.quit();		
	}

	@Given("^List of WebElement ids to test$")
	public void get_id_list(List<String> value) {
		this.idList = value;
	}
	
	@Given("^List of Breakpoint values to test$")
	public void get_BP_list(List<String> value) {
		this.BPList = value;
	}
	
	@Given("^List of CSS values to test$")
	public void get_css_list(List<String> value) {
		this.cssList = value;
	}
	
	@Then("^Compare URL1 = \"([^\"]*)\" and URL2 = \"([^\"]*)\"$")
	public void compare_two_urls_idList_BpList_cssList(String URL1, String URL2) throws InterruptedException {
		
		if(idList.isEmpty() || BPList.isEmpty() || cssList.isEmpty()) {
			System.out.println("id or BP or css lists not set correctly in feature. Exiting.");
			System.exit(0);
		}
			
		WebDriver driver1 = new ChromeDriver();
		driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver1.get(URL1);

		ArrayList<DataWebElement> url1Data = resizeBrowserAndGetElementValues(driver1, BPList, idList, cssList,URL1);
		
		driver1.quit();
		
		WebDriver driver2 = new ChromeDriver();
		driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver2.get(URL2);

		ArrayList<DataWebElement> url2Data = resizeBrowserAndGetElementValues(driver2, BPList, idList, cssList,URL1);
		driver2.quit();

		compareDataFromBothURLs(url1Data, url2Data);
		
	}
	
	
	//Common functions
	
	public void getAllDataForURL(String URL, ArrayList<DataWebElement> urlData) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(URL);

		List<String> bpListURL = getBPValuesFromURL(driver.findElements(By.xpath("//*[@id]")));
		urlData = resizeBrowserAndGetElementValues(driver, bpListURL, URL);
		
		driver.quit();
	}
	
	//Method to get data from URL at set the data-structure accordingly
	public ArrayList<DataWebElement> resizeBrowserAndGetElementValues(WebDriver driver, List<String> bpListURL, String URL) throws InterruptedException {
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
			Thread.sleep(1000);
			
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
	
	//Overload: Method to take element ID directly and return data
	public ArrayList<DataWebElement> resizeBrowserAndGetElementValues(WebDriver driver, List<String> bpListURL, String URL, String WebElementID) throws InterruptedException {
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
			Thread.sleep(1000);
			
			for(WebElement e: elementsURL) {
				DataWebElement data = new DataWebElement();
				if(e.getAttribute("id").equals(WebElementID)) {
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

	//Overload: Method to compare all elements for all CSS values
	public ArrayList<DataWebElement> resizeBrowserAndGetElementValues(WebDriver driver, List<String> bpListURL, String URL, boolean ALLCSS) throws InterruptedException {
		
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
			Thread.sleep(1000);
			
			for(WebElement e: elementsURL) {
				DataWebElement data = new DataWebElement();
				data.setBP(bp);
				if(ALLCSS) {
					data.setID(e.getAttribute("id"));
					data.setAllCssValues(getRunTimeCss(driver, e));
					data.setCssArray();
				}
				else 
					if(e.getAttribute("id").contains("u")) {

						data.setID(e.getAttribute("id"));
						data.setWidth(e.getCssValue("width"));
						data.setMarginLeft(e.getCssValue("margin-left"));
						data.setPerspectiveOrigin(e.getCssValue("perspective-origin"));
				}
				urlData.add(data);
			}
		}
		
		return urlData;
	}

	//Overload: Method to compare all elements for given id, BP and CSS values
	public ArrayList<DataWebElement> resizeBrowserAndGetElementValues(WebDriver driver, List<String> bpListURL, List<String> idListURL, List<String> cssListURL, String URL) throws InterruptedException {
		
		driver.navigate().refresh();
		ArrayList<DataWebElement> urlData = new ArrayList<DataWebElement>();
		for(String bp : bpListURL) {
			Integer value = Integer.parseInt(bp.replace("bp_", ""));
			Dimension dimension= new Dimension(value, 1000);
			driver.manage().window().setSize(dimension);
			
			List<WebElement> elementsURL = getElementsFromURL(driver, URL, idListURL);
			Thread.sleep(1000);
			
			for(WebElement e: elementsURL) {
				DataWebElement data = new DataWebElement();
				data.setBP(bp);
				data.setID(e.getAttribute("id"));
				data.setAllCssValues(getRunTimeCss(driver, e));
				data.setCssArrayList(cssList);
				urlData.add(data);
			}
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
	
	public List<WebElement> getElementsFromURL(WebDriver driver, String URL, List<String> elementIDs) {
		
		driver.get(URL);
		List<WebElement> elementListURL = new ArrayList<WebElement>();
		
		if(elementIDs.size() == 0) {
			System.out.println("List is empty");
			return elementListURL;
		}
		else {
			for(String s : elementIDs) {
				WebElement e = driver.findElement(By.id(s));
				System.out.println(e);
				elementListURL.add(e);
			}
			
			return elementListURL;
		}
	}
	
	public void compareDataFromBothURLs(ArrayList<DataWebElement> url1Data, ArrayList<DataWebElement> url2Data) {
		Iterator<DataWebElement> it1 = url1Data.iterator();
		Iterator<DataWebElement> it2 = url2Data.iterator();
		
		while(it1.hasNext() && it2.hasNext()) {
			
			DataWebElement d1 = it1.next();
			DataWebElement d2 = it2.next();
			
			assertFalse("ID should not be empty at BP:"+d1.getBP(),d1.getID().isEmpty());
			assertFalse("ID should not be empty at BP:"+d2.getBP(),d2.getID().isEmpty());
			
			System.out.println("---------------Validating element:"+d1.getID()+" against element:"+d2.getID()+" at BP:"+d1.getBP()+"----------------------");
				if(d1.getBP().equals(d2.getBP()) && d1.getID().equals(d2.getID())) 
				{

					if(d1.getAllCSSValues() == "" && d2.getAllCSSValues()== "")
					{
					assertEquals(d1.getWidth(), d2.getWidth());
					assertEquals(d1.getMarginLeft(), d2.getMarginLeft());
					assertEquals(d1.getPerspectiveOrigin(), d2.getPerspectiveOrigin());
					
					}
					else
					{
						ArrayList<String> arr1 = d1.getCssArray();
						ArrayList<String> arr2 = d2.getCssArray();
						
						for (int i = 0; i < arr1.size(); i++) {
							assertEquals(arr1.get(i),arr2.get(i));
				        }
					}
				}
			}
	}
	
	public String getRunTimeCss(WebDriver driver, WebElement we) {
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		  String script = "var s = '';" +
		                  "var o = getComputedStyle(arguments[0]);" +
		                  "for(var i = 0; i < o.length; i++){" +
		                  "s+=o[i] + ':' + o.getPropertyValue(o[i])+';'+'\\n';}" + 
		                  "return s;";
		  
		  return executor.executeScript(script, we).toString();
	}
}
