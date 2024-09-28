package tests.bookTests;

import base.BaseTest;
import com.gobus.pages.base.HomePage;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import utilities.ReadXLSFile;

public class PositionTest extends BaseTest {
    @Test(dataProvider = "testdata" ,dataProviderClass = ReadXLSFile.class)
    public void testPositionSelection(String source, String station, String destination){
        var position = HomePage.accessBookGoBus().getTripChoisePositionComponent();

        // verify source selection
        position.selectSourceStation(source, station);
        String actualStation = position.getSource();
        Assert.assertEquals(actualStation, station, "Actual Source and Expected Source do not match");

        // verify destination selection
        position.selectDestination(destination);
        String actualDestination = position.getDestination();
        Assert.assertEquals(actualDestination, destination, "Actual destination and Expected destination do not match");

    }
}
