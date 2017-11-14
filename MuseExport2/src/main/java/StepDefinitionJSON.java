package main.java;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import main.java.utils.DataWebElement;

import static io.restassured.RestAssured.*;
import static io.restassured.path.json.JsonPath.*;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitionJSON {
	
	String host = null;
	String port = null;
	String method = null;
	List<String> idList = new ArrayList<String>();
	List<String> BPList = new ArrayList<String>();
	List<String> cssList = new ArrayList<String>();
	
	
	@Before
	public void setup() {
		this.host = "http://boltwebserver.corp.adobe.com";
		this.port  = "3000";
		this.method = "/compareURL";
	}
	
	@Given("^Compare sites from URL1 = \"([^\"]*)\" and URL2 = \"([^\"]*)\" using WebService$")
	public void compare_using_JSON(String URL1, String URL2) {
		
		System.out.println("URL1="+URL1+" | URL2="+URL2);
		
		String url1 = "url1="+URL1;
		String url2 = "url2="+URL2;
		String request = host+":"+port+method+"?"+url1+"&"+url2;
		
		System.out.println("---------------------Processing Request-------------------------");
		String response = get(request).asString();
		System.out.println(response);
		
		HashMap<String,String> details = from(response).get("Details");
		
		for(Map.Entry<String, String> e : details.entrySet())
		{
			System.out.println(e.getKey()+"|"+e.getValue());
			assertFalse(e.getValue(), e.getValue().contains("Error"));
		}
	}
	
	@Given("^List of WebElement ids for JSON Object$")
	public void get_id_list(List<String> value) {
		this.idList = value;
	}
	
	@Given("^List of Breakpoint values for JSON Object$")
	public void get_BP_list(List<String> value) {
		this.BPList = value;
	}
	
	@Given("^List of CSS values for JSON Object$")
	public void get_css_list(List<String> value) {
		this.cssList = value;
	}
	
	@Then("^Compare URL1 = \"([^\"]*)\" and URL2 = \"([^\"]*)\" via POST$")
	public void compare_two_urls_idList_BpList_cssList(String URL1, String URL2) throws InterruptedException {
		

	}
	
}
