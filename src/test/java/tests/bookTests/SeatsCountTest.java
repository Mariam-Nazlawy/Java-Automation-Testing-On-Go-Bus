package tests.bookTests;

import base.BaseTest;
import com.gobus.pages.base.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReadXLSFile;

public class SeatsCountTest extends BaseTest {

    @Test(dataProvider = "testdata" ,dataProviderClass = ReadXLSFile.class)
    public void testSeatsCount(String minCount, String maxCount){

        var seatsCountComponent = HomePage.accessBookGoBus().getSeatsCountComponent();
        String ActualCount;
        String ExpectedCount;

        // verify the default count is the min count
        ActualCount = seatsCountComponent.getSeatsCount();
        Assert.assertEquals(ActualCount, minCount, "\nActual count and Expected count do not match\n" +
                                               "Actual : ("+ ActualCount +" ) , Expected : (" + minCount +")\n");

        // verify there is no vale less than the min count
        seatsCountComponent.decreaseSeatsByOne();
        Assert.assertEquals(ActualCount, minCount, "\nActual count and Expected count do not match\n" +
                "Actual : ("+ ActualCount +" ) , Expected : (" + minCount +")\n");

        // verify the incremental button
        seatsCountComponent.increaseSeatsByOne();
        ActualCount = seatsCountComponent.getSeatsCount();
        ExpectedCount = "2";
        Assert.assertEquals(ActualCount, ExpectedCount, "\nActual count and Expected count do not match\n" +
                "Actual : ("+ ActualCount +" ) , Expected : (" + ExpectedCount +")\n");

        // verify the decremental button
        seatsCountComponent.decreaseSeatsByOne();
        ActualCount = seatsCountComponent.getSeatsCount();
        Assert.assertEquals(ActualCount, minCount, "\nActual count and Expected count do not match\n" +
                "Actual : ("+ ActualCount +" ) , Expected : (" + minCount +")\n");

        // verify the count does not exceed the max count
        boolean isExceeded = seatsCountComponent.isExceededMaxCount(maxCount);
        ActualCount = seatsCountComponent.getSeatsCount();
        Assert.assertFalse(isExceeded, "\nthe count of seats exceeds the max count of seats\n" +
                                          "Expected: ("+ maxCount +") , Found: ("+ ActualCount +")");
    }
}
