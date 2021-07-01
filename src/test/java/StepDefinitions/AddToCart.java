package StepDefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.Bunnings.Methods.BunningsHomePageMethods;
import com.qa.Bunnings.Methods.ReviewCartPageMethods;
import com.qa.BunningsPageObjects.ReviewCartPage;

import Resources.Base;
import Resources.WaitUtils;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class AddToCart extends Base{
	public static WebDriver driver;
	WaitUtils wait;
	BunningsHomePageMethods bunningsHomePageMethods;
	ReviewCartPageMethods reviewCartPagMethods;
	@Before
	public void beforeScenario() throws IOException {
		driver=initializeDriver();
		bunningsHomePageMethods=new BunningsHomePageMethods(driver);
		reviewCartPagMethods=new ReviewCartPageMethods(driver);
		wait=new WaitUtils(driver);
		wait.waitFor(10);
		driver.manage().window().maximize();
	}
	
	
	
	@Given("^User landed on bunnings.com$")
	public void user_landed_on_bunningsurl() throws Throwable {
		openUrl(readProperty("Url"));
		bunningsHomePageMethods.verifyHomePageIsDisplayed();
	}
	@When("^User enters \"(.*)\"$")
	public void user_enters_searchtext(String searchtext)  {
		bunningsHomePageMethods.enterSearchTextInProductSearchBar(searchtext);
	}
	@Then("^Verify error message is displayed successfully with \"(.*)\"$")
	public void verify_error_message_is_displayed(String searchtext) {
		bunningsHomePageMethods.verifyErrorMsgIsDisplayed(searchtext);
	}
	@Then("^Verify products wrt \"(.*)\" will get displayed$")
	public void verify_products(String searchtext) throws Throwable {
		bunningsHomePageMethods.verifyProducts(searchtext);
	}
	@Then("^Click on Add to cart button for the first displayed product$")
	public void click_on_add_to_cart_first_product()  {
		bunningsHomePageMethods.clickOnAddToCartBtnForFirstProduct();
	}
	 @Then("^Verify one quantity should get displayed$")
	    public void verify_one_quantity_should_get_displayed() {
		 bunningsHomePageMethods.verifyQuantity();
	    }

	    @Then("^Increase and decrease quantity and verify$")
	    public void increase_quantity_and_verify() throws InterruptedException {
	    	bunningsHomePageMethods.verifyIncreaseDecreaseQuantity();
	    }

	    @Then("^Click on Review and Checkout and verify product details$")
	    public void click_on_review_and_checkout() throws IOException {
	    	reviewCartPagMethods.verifyProductDetails();
	    }

	@After
	public void afterScenario() throws IOException {
		closeDriver();
	}
}
