package com.qa.BunningsPageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewCartPage  {
	public WebDriver driver;
	
	public ReviewCartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h4[@datalocator='ItemForClickCollect_Product_Name']")
	public List<WebElement> textAllProductsReviewCartPage;
	
	@FindBy(xpath="//h2[@id='reviewCart']")
	public WebElement reviewCartPageLabel;

	 public WebElement getPricePart1ReviewCart(String text) {
		    return driver.findElement(By.xpath(String.format("//h4[text()='%s']//parent::a//parent::div//parent::div//following-sibling::div//p", text)));
		  }
	
	 public WebElement getPricePart2ReviewCart(String text) {
		    return driver.findElement(By.xpath(String.format("//h4[text()='%s']//parent::a//parent::div//parent::div//following-sibling::div//p/sup", text)));
		  }

}

