package TestRunner;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
 features="src/test/java/Feature"
 ,glue={"StepDefinitions"},tags="@SanityTest",strict=true,monochrome=true,
		    plugin= {"pretty","html:target/cucumber","json:target/cucumber.json","junit:target/cukes.xml"}
 )
 
public class TestRunner {
 
}