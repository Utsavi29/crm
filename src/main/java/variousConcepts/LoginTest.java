package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	static WebDriver driver;

	public static void main(String[] args) {
// calling method multiple times is not an ideal process so we have another way of writing		
		init();
		loginTest();
		tearDown();

		init();
		negativeLoginTest();
		tearDown();

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\utsav\\Selenium\\crm\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//to find element
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();

// to close , to quit

		driver.close();
		driver.quit();

//Now we need to do negative testing but can not alter the above code because we will loose the positive testing. therefore we need 
//to create method for positive n negative testing each.

	}

//we call this code init compy standard because this peice of code is for launching browser is common for negative n positive testing.
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\utsav\\Selenium\\crm\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

// Login test
// we also see red scribbling at this code and next code because there is no local webDriver object hence create Global webdriver . 
	// and static since all other methods are static.
	public static void loginTest() {
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();

	}

	// tearDown is for close bit of code which ic common with neg n positive
	// Testing.

	public static void tearDown() {
		driver.close();
		driver.quit();

	}

	// Negative testing we jst need actual test and can use init and teardown method as common one to call negative and positive test cases.

	public static void negativeLoginTest() {

		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc12345");
		driver.findElement(By.name("login")).click();

	}
	// now call the methods in main method
	
	// Since there are only two test cases here we can call in the main method multiple times but when there are 100 test cases it gets hard
	//n clumsy n could make mistake while calling it so many time . that is where junit comes in practice.

}
