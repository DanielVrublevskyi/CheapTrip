import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchTest extends TestBase{

    @DataProvider
    public Iterator<Object[]> validCity(){
        List<Object[]> List = new ArrayList<>();
        List.add(new Object[]{"Odesa", "Kiev"});
        List.add(new Object[]{"London", "Toronto"});
        List.add(new Object[]{"Paris", "Sydney"});
        return List.iterator();
    }

    @DataProvider
    public Iterator<Object[]> validCityFromCSV() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src\\test\\resources\\EuropeCities.csv")));
        List<Object[]> List = new ArrayList<>();
        String line = reader.readLine();

        while (line!=null){
            String[] split = line.split(",");
            List.add(new String[]{split[0], split[1]});
//            List.add(line.split(","));
            line=reader.readLine();
        }
//        reader.close();

        return  List.iterator();
    }

//    @BeforeClass
//    public void ensurePreconditions() {
//        if (!isElementPresent(By.cssSelector("input[name='ion-input-1']"))) {
//            wd.get("http://test70.lowcoststrip.com/");
//        }
//    }

    @Test (dataProvider = "validCity")
    public void sendRequestWithDataProvider(String CityFrom, String CityTo) throws InterruptedException {

        if(!isElementPresent(By.cssSelector("input[name='ion-input-1']"))){
            wd.get("http://test70.lowcoststrip.com/");
        }
            Thread.sleep(3000);
            fillFromField(CityFrom);
            Thread.sleep(2000);
            fillToField(CityTo);

            clickOnSearchButton();
            Assert.assertTrue(isElementPresent(By.cssSelector("a")));
            Thread.sleep(2000);

    }

    @Test (dataProvider = "validCityFromCSV")
    public void sendRequestWithCSVDataProvider(String CityFrom, String CityTo) throws InterruptedException {
//        if(!isElementPresent(By.cssSelector("input[name='ion-input-1']"))){
//            wd.get("http://test70.lowcoststrip.com/");
//        }
            fillFromField(CityFrom);
            Thread.sleep(2000);
            fillToField(CityTo);

            clickOnSearchButton();
            Assert.assertTrue(isElementPresent(By.cssSelector("a")));


    }



    @Test
    public void sendRequest() throws InterruptedException {
    if(!isElementPresent(By.cssSelector("input[name='ion-input-1']"))){
        wd.get("http://test70.lowcoststrip.com/");
    }
        fillFromField("Odesa");
        Thread.sleep(2000);
        fillToField("Kiev");

        clickOnSearchButton();
        Assert.assertTrue(isElementPresent(By.cssSelector("a")));
    }


}
