import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    WebDriver wd;
    private String cityTo;

    @BeforeSuite
    public void init(){
     wd = new ChromeDriver();
     wd.manage().window().maximize();
//     wd.get("http://test70.lowcoststrip.com/");
        wd.get("http://test70.lowcoststrip.com/contact");
    }

    @AfterSuite(enabled = false)
    public void close(){
        wd.quit();
    }

    protected void fillToField(String CityTo) {
        type(By.cssSelector("input[name='ion-input-1']"), CityTo);
        click(By.xpath("//p[contains(text(),'"+ CityTo + "')]"));
    }

    protected void fillFromField(String CityFrom) {
        type(By.cssSelector("input[name='ion-input-0']"), CityFrom);
        click(By.xpath("//p[contains(text(),'" + CityFrom +"')]"));
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

    protected void clickOnSearchButton() {
        click(By.cssSelector("ion-app.md.ion-page.hydrated ion-split-pane.md.split-pane-md.hydrated ion-router-outlet.split-pane-main.menu-content.menu-content-overlay.hydrated app-places.ion-page div.tabs-inner ion-router-outlet.hydrated app-discover.ion-page ion-content.md.hydrated:nth-child(3) ion-card.md.hydrated ion-card-content.md.card-content-md.hydrated ion-grid.md.hydrated ion-row.md.hydrated:nth-child(2) ion-col.buttons.md.hydrated > ion-button.ion-color.ion-color-primary.md.button.button-small.button-solid.ion-activatable.ion-focusable.hydrated:nth-child(2)"));
    }
}
