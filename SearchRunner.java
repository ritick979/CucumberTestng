package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 

@CucumberOptions(
		features = "C:\\Users\\Mr\\Documents\\workspace-spring-tool-suite-4-4.23.1.RELEASE\\Cucumber\\src\\test\\resources\\Sparsh\\Contact.feature", 
		glue = "Steps"
		)
public class SearchRunner {

}
