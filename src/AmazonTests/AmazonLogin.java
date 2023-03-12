package AmazonTests;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonLogin {
	
	WebDriver driver;
	@BeforeMethod
	
	public void setUp() {
		System.setProperty("WebDriver.chrome.driver", "C:\\Program Files\\Drivers for selinium\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(options);
		driver.get("https://amazon.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	}
	
	@Test
	public void testCase1() {
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		String expTitle = "Amazon.com. Spend less. Smile more.";
		Assert.assertEquals(actTitle, expTitle);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
 