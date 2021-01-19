import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends TestBase{


    @Test
    public void sendRequest() throws InterruptedException {
        fillFromField("Odesa");
        Thread.sleep(2000);
        fillToField("Kiev");

        clickOnSearchButton();
        Assert.assertTrue(isElementPresent(By.cssSelector("a")));
    }

}
