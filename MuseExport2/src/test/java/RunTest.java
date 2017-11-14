package test.java; 

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources",
		glue={"main.java"},
		//tags= {"@single","@id"},
		//name="id specific",
		plugin = {"pretty", "html:target/OutReport"}
		)
 
public class RunTest {
		/*
	    * This class should be empty, step definitions should be in separate classes.
	    */
}