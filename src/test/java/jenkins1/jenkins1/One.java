package jenkins1.jenkins1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class One {
	WebDriver driver;

    @Test
    public void EnterCustomerID() throws InterruptedException {
        driver.switchTo().frame("login_page");
        driver.findElement(By.xpath("//a[contains(text(),'CONTINUE')]")).click();
        String ExpAlertMsg="Customer ID  cannot be left blank.";
        String ActAlertMsg=driver.switchTo().alert().getText();
        Assert.assertEquals(ExpAlertMsg, ActAlertMsg);
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        // This will take you out from frame to outside
        driver.switchTo().defaultContent();
    }

    // Pre-Condition
    @BeforeTest
    public void LaunchBrowser() {
    	 WebDriverManager.chromedriver().setup();  // Automatically sets up the correct driver
         driver = new ChromeDriver();
        driver.manage().window().maximize();
        // This will wait for Page to load
        // driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        // This will store or rememember the cookies or navigation in terms of
        // back and forward
        //driver.navigate().to("https://netbanking.hdfcbank.com/netbanking/");
        driver.get("https://netbanking.hdfcbank.com/netbanking/");
    }

    // Post Condition
    @AfterTest
    public void CloseBrowser() {
        driver.quit();
    }

}
