package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	public static WebDriver driver;
	public Properties prop;
	public FileInputStream fis;

	public WebDriver initializeDriver() throws IOException {
		String browserName = readProperty("browser");
		// execute in chrome driver
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\Executables\\chromedriver.exe");
			driver = new ChromeDriver();
			// firefox code
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					(System.getProperty("user.dir") + "\\src\\main\\java\\Executables\\geckodriver.exe"));
			driver = new FirefoxDriver();
		//ie code
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver",
					(System.getProperty("user.dir") + "\\src\\main\\java\\Executables\\IEDriverServer.exe"));
			driver = new InternetExplorerDriver();
			// edge code
		} else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver",
					(System.getProperty("user.dir") + "\\src\\main\\java\\Executables\\msedgedriver.exe"));
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public String readProperty(String value) throws IOException {
		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\config.properties");
		prop = new Properties();
		prop.load(fis);
		return prop.getProperty(value);
	}

	public void closeDriver()
	{
		driver.close();
	}
	public void openUrl(String url) {
		driver.get(url);
	}

	public void scrollToWebElement(WebElement ele)
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
	}
}
