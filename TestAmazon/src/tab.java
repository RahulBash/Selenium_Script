import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class tab {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rahul\\Documents\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.amazon.in/");
       
        
        driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("soap");
        driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);
        
        driver.findElement(By.linkText("Liril Lemon & Tea Tree Oil Soap 125 g (Pack of 6)")).click();
       
       
        String currentWindow = driver.getWindowHandle();// get handle of current window
        Set<String> handles = driver.getWindowHandles();// get handle of all windows
        Iterator<String> it = handles.iterator();
        while (it.hasNext()) {
        if (currentWindow == it.next()) {
        continue;
        }
        driver = driver.switchTo().window(it.next());// switch to new window

        }
        clickOn(driver, driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")), 20);//addtocart
    }
    
        public static void clickOn(WebDriver driver, WebElement locator, int timeout) {
         new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
         locator.click();	
      
        }

}
