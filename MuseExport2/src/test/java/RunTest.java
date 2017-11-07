package test.java; 

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:target/OutReport"},
		features = "src/test/resources",
		glue={"main.java"}
		)
 
public class RunTest {
		/*
	    * This class should be empty, step definitions should be in separate classes.
	    */
}