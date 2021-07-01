package com.qa.BunningsPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BunningsHomePage  {
	public WebDriver driver;
	
	public BunningsHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='custom-css-outlined-input']")
	public WebElement productSearchBar;
	
	@FindBy(xpath="//div[@data-locator='Search-Icon']//button[@aria-label='search']")
	public WebElement productSearchBtn;
	
	@FindBy(xpath="//p[text()='We found 0 results for']")
	public WebElement noProductsErrorMsgpart1;
	
	@FindBy(xpath="//img[contains(@thumbnailsrc,'https://bunningscontenthub.bunnings.com')][@alt='Bunnings']")
	public WebElement bunningTopHeadingHomePage;
	
	@FindBy(xpath="//p[contains(text(),'We found')]")
	public WebElement productsFoundMsg;
	
	@FindBy(xpath="//input[@title='Press Enter or Tab key to apply quantity']")
	public WebElement quantity;
	
	@FindBy(xpath="//button[@aria-label='Increase quantity']")
	public WebElement increaseQuantity;
	
	@FindBy(xpath="//button[@aria-label='Decrease quantity']")
	public WebElement decreaseQuantity;
	
	@FindBy(xpath="//button[@data-locator='atcButton']")
	public List<WebElement> addToCartButton;
	
	@FindBy(xpath="//span[text()='Review & checkout']//parent::button")
	public WebElement reviewAndCheckOutButton;
	
	@FindBy(xpath="//div[@class='text-rating-container']/a/p")
	public List<WebElement> textAllProducts;
	
	@FindBy(xpath="	//p[contains(text(),'Showing')]")
	public WebElement showingLabel;

	 public WebElement getPricePart1(String text) {
		    return driver.findElement(By.xpath(String.format("//p[text()='%s']//parent::a//parent::div//parent::div//parent::div//parent::div//parent::div//following-sibling::div[contains(@data-locator,'bottom')]//p", text)));
		  }
	 public WebElement getPricePart2(String text) {
		    return driver.findElement(By.xpath(String.format("//p[text()='%s']//parent::a//parent::div//parent::div//parent::div//parent::div//parent::div//following-sibling::div[contains(@data-locator,'bottom')]//p/sup", text)));
		  }
	
	 public WebElement getErrorMsg(String searchText) {
		    return driver.findElement(By.xpath(String.format("//p[text()='%s']", searchText)));
		  }

	 public List<WebElement> getProducts(String searchText) {
		    return driver.findElements(By.xpath(String.format("//div/article/a[contains(@href,'%s')]", searchText)));
		  }
}
