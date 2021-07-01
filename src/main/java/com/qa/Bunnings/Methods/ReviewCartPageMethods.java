package com.qa.Bunnings.Methods;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.qa.BunningsPageObjects.BunningsHomePage;
import com.qa.BunningsPageObjects.ReviewCartPage;
import Resources.Base;
import Resources.LoggerHelper;
import Resources.WaitUtils;

public class ReviewCartPageMethods extends Base {
	public static WebDriver driver;
	public BunningsHomePage homepage;
	public ReviewCartPage reviewCartPage;
	WaitUtils wait;
	Logger log = LoggerHelper.getLogger(LoggerHelper.class);
	public ReviewCartPageMethods(WebDriver driver) {
		this.driver = driver;
		wait = new WaitUtils(driver);
		PageFactory.initElements(driver, this);
		homepage = new BunningsHomePage(driver);
		reviewCartPage = new ReviewCartPage(driver);
	}

	public void verifyProductDetails() throws IOException {
		wait.waitFor(10);
		//add to cart page
		String prodNameAddToCartPage = homepage.textAllProducts.get(0).getText();
		String price1AddToCartPage = homepage.getPricePart1(prodNameAddToCartPage).getText();
		String price2AddToCartPage = homepage.getPricePart2(prodNameAddToCartPage).getText();
		log.info("Add to Cart Product details"+prodNameAddToCartPage+","+price1AddToCartPage+","+price2AddToCartPage);
		// click on review button
		homepage.reviewAndCheckOutButton.click();
		wait.waitForElementToBeVisible(reviewCartPage.reviewCartPageLabel);
		scrollToWebElement(reviewCartPage.reviewCartPageLabel);
		// review page
		String prodNameReviewPage = reviewCartPage.textAllProductsReviewCartPage.get(0).getText();
		String price1ReviewPage = reviewCartPage.getPricePart1ReviewCart(prodNameReviewPage).getText();
		String price2ReviewPage = reviewCartPage.getPricePart2ReviewCart(prodNameReviewPage).getText();
		log.info("Review Cart Product details"+prodNameReviewPage+","+price1ReviewPage+","+price2ReviewPage);
		//verify product details
		Assert.assertEquals(prodNameAddToCartPage, prodNameReviewPage);
		Assert.assertEquals(price1AddToCartPage, price1ReviewPage);
		Assert.assertEquals(price2AddToCartPage, price2ReviewPage);
		log.info("verified product data :Success");
	}
}
