package StepDefinitions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {


	@Before
    public void beforeScenario(Scenario scenario){
        System.out.println("running scenario is :"+scenario.getName());
    }
	@After
    public void afterScenario(Scenario scenario){
        System.out.println("status of scenario :"+scenario.getName()+"status :"+scenario.getStatus());
    }
}