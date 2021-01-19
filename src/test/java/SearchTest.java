import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends TestBase{


    @Test
    public void sendRequest() throws InterruptedException {
        fillFromField("Odesa");
        Thread.sleep(2000);
        fillToField("Kiev");

        click(By.cssSelector("ion-app.md.ion-page.hydrated ion-split-pane.md.split-pane-md.hydrated ion-router-outlet.split-pane-main.menu-content.menu-content-overlay.hydrated app-places.ion-page div.tabs-inner ion-router-outlet.hydrated app-discover.ion-page ion-content.md.hydrated:nth-child(3) ion-card.md.hydrated ion-card-content.md.card-content-md.hydrated ion-grid.md.hydrated ion-row.md.hydrated:nth-child(2) ion-col.buttons.md.hydrated > ion-button.ion-color.ion-color-primary.md.button.button-small.button-solid.ion-activatable.ion-focusable.hydrated:nth-child(2)"));
        Assert.assertTrue(isElementPresent(By.cssSelector("a")));
    }
}
