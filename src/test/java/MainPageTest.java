import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class MainPageTest extends TestBase{


    @Test
    public void openSite() throws InterruptedException {
        Assert.assertTrue(isElementPresent(By.cssSelector("ion-title.hide-xs")));


    }




}
