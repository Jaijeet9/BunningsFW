package Resources;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	public WebDriver driver;

	public WaitUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void waitFor(long timeUnitInSeconds) throws IOException {
		driver.manage().timeouts().implicitlyWait(timeUnitInSeconds, TimeUnit.SECONDS);
	}

	public void waitForElementToBeVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
