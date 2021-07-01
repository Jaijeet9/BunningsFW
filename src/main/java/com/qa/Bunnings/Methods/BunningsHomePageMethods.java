package com.qa.Bunnings.Methods;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.qa.BunningsPageObjects.BunningsHomePage;
import Resources.Base;
import Resources.LoggerHelper;
import Resources.WaitUtils;

public class BunningsHomePageMethods extends Base {
	public static WebDriver driver;
	public BunningsHomePage homepage;
	WaitUtils wait;
	Logger log = LoggerHelper.getLogger(LoggerHelper.class);
	
 	public BunningsHomePageMethods(WebDriver driver) {
		this.driver = driver;
		wait = new WaitUtils(driver);
		PageFactory.initElements(driver, this);
		homepage = new BunningsHomePage(driver);
	}

	public void enterSearchTextInProductSearchBar(String searchtext) {
		log.info("entering searchtext in the product search bar");
		homepage.productSearchBar.sendKeys(searchtext);
		homepage.productSearchBtn.click();
		log.info("search success");
	}

	public void verifyErrorMsgIsDisplayed(String searchtext) {
		wait.waitForElementToBeVisible(homepage.bunningTopHeadingHomePage);
		Assert.assertTrue(homepage.noProductsErrorMsgpart1.isDisplayed());
		Assert.assertTrue(homepage.getErrorMsg(searchtext).isDisplayed());
		log.info("error message for no products found");
	}

	public void verifyHomePageIsDisplayed() {
		wait.waitForElementToBeVisible(homepage.bunningTopHeadingHomePage);
		Assert.assertTrue(homepage.bunningTopHeadingHomePage.isDisplayed());
		log.info("verify bunnings home page is displayed");
	}

	public void verifyProducts(String searchtext) throws InterruptedException {
		wait.waitForElementToBeVisible(homepage.productsFoundMsg);
		List<WebElement> products = new ArrayList<WebElement>();
		products.addAll(homepage.getProducts(searchtext));
		log.info("products"+products);
		for (WebElement ele : products) {
			System.out.println("ele" + ele);
			Assert.assertTrue(ele.isDisplayed());
		}
		log.info("products displayed wrt search Hammer");
	}

	public void clickOnAddToCartBtnForFirstProduct() {
		wait.waitForElementToBeVisible(homepage.productsFoundMsg);
		List<WebElement> atc = new ArrayList<WebElement>();
		atc.addAll(homepage.addToCartButton);
		atc.get(0).click();
	}
	public void verifyQuantity() {
		wait.waitForElementToBeVisible(homepage.quantity);
		Assert.assertTrue(homepage.quantity.getAttribute("value").equals("1"));
	}
	public void verifyIncreaseDecreaseQuantity() throws InterruptedException {
		scrollToWebElement(homepage.showingLabel);
		Thread.sleep(3000);
		wait.waitForElementToBeVisible(homepage.increaseQuantity);
		homepage.increaseQuantity.click();
		Thread.sleep(3000);
		Assert.assertTrue(homepage.quantity.getAttribute("value").equals("2"));
		wait.waitForElementToBeVisible(homepage.decreaseQuantity);
		homepage.decreaseQuantity.click();
		Thread.sleep(3000);
		Assert.assertTrue(homepage.quantity.getAttribute("value").equals("1"));
	}
	public void verifyAndClickReviewAndCheckOutBtn() {
		wait.waitForElementToBeVisible(homepage.reviewAndCheckOutButton);
		homepage.reviewAndCheckOutButton.click();
		log.info("review and checkout button clicked");
	}
}
