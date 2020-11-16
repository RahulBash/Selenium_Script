
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;




public class cart {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rahul\\Documents\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
       
        
        driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("soap");
        driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);
        
        driver.findElement(By.linkText("Cinthol Confidence+ Bath Soap 99.9% Germ Protection, 100g (Pack of 8)")).click();
       
       
        String currentWindow = driver.getWindowHandle();// get handle of current window
        Set<String> handles = driver.getWindowHandles();// get handle of all windows
        Iterator<String> it = handles.iterator();
        while (it.hasNext()) {
        if (currentWindow == it.next()) {
        continue;
        }
        driver = driver.switchTo().window(it.next());// switch to new window

        }
        driver.findElement(By.xpath("//button[text()='submit.add-to-cart']")).click();
      
    
    }

}
