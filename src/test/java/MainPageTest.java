import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class MainPageTest {


    WebDriver wd;

    @BeforeMethod
    public void init(){
     wd = new ChromeDriver();
     wd.manage().window().maximize();
     wd.get("http://test70.lowcoststrip.com/");
    }

    @Test
    public void




}
