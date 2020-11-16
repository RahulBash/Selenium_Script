import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class today {

    static ChromeDriver driver = null;
    static WebDriverWait wait = null;
    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rahul\\Documents\\chromedriver_win32\\chromedriver.exe");
      
		driver = new ChromeDriver();     
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
}
	
	@Before
	public void setUp() throws Exception {
		driver.get("https://www.amazon.in/");
		
	}
	@Test
	public void testAddToCart() throws InterruptedException {
		driver.get("https://www.amazon.in/");
		driver.findElement(By.linkText("Today's Deals")).click();
		wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Today's Deals")));
       
        
        Assert.assertTrue(driver.getTitle().equals("Amazon.in Today's Deals: Great Savings. Every Day."));
    
        driver.findElement(By.id("100 9cd16a6e-announce")).click();
        
        Thread.sleep(3000);
        
        driver.findElement(By.cssSelector("input[id='ap_email']")).sendKeys("borrower1000@gmail.com");
        driver.findElement(By.cssSelector("input[id='continue']")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("input[id='ap_password']")).sendKeys("Hotchips60");        
        driver.findElement(By.cssSelector("input[id='signInSubmit']")).sendKeys(Keys.ENTER);
        
        wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-cart")));
        
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		
		
	}
	
}
