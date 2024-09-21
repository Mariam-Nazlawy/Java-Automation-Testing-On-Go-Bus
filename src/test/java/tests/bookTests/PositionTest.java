package tests.bookTests;

import base.BaseTest;
import com.gobus.pages.base.HomePage;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class PositionTest extends BaseTest {
    @Test
    public void testPositionSelection(){
        var position = HomePage.accessBookGoBus().getTripChoisePositionComponent();

        String source = "Cairo";
        String station = "Cairo ( Tahrir )";
        String destination = "Aswan";

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
