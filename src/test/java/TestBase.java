import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    WebDriver wd;

    @BeforeMethod
    public void init(){
     wd = new ChromeDriver();
     wd.manage().window().maximize();
     wd.get("http://test70.lowcoststrip.com/");
    }

    protected void fillToField(String City) {
        type(By.cssSelector("input[name='ion-input-1']"), City);
        click(By.xpath("//p[contains(text(),'"+ City + "')]"));
    }

    protected void fillFromField(String City) {
        type(By.cssSelector("input[name='ion-input-0']"), City);
        click(By.xpath("//p[contains(text(),'" + City +"')]"));
    }

    public boolean isElementPresent(By locator){
       try {
           wd.findElement(locator);
           return true;
       } catch (NoSuchElementException ex){
           return false;
       }

    }

    public void type(By locator, String text){
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }
}
