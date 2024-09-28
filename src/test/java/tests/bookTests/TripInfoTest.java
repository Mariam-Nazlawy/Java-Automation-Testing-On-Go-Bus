package tests.bookTests;

import base.BaseTest;
import com.gobus.pages.base.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ReadXLSFile;


public class TripInfoTest extends BaseTest {
    @Test(dataProvider = "testdata" ,dataProviderClass = ReadXLSFile.class)
    public void testTripInfo(String source, String station, String destination,
                             String date, String monthandYear, String day,
                             String numberOfSeats){
        var gobusForm = HomePage.accessBookGoBus();


        // Test switching to One Way (assuming one-way is default)
        var tripSwitcher = gobusForm.getTripTypeSwitcherComponent();
        Assert.assertTrue(tripSwitcher.isOneWaySelected(), "One Way should be selected by default");


        // verify source selection
        var position = gobusForm.getTripChoisePositionComponent();
        position.selectSourceStation(source, station);
        String actualStation = position.getSource();
        Assert.assertEquals(actualStation, station, "Actual Source and Expected Source do not match");

        // verify destination selection
        position.selectDestination(destination);
        String actualDestination = position.getDestination();
        Assert.assertEquals(actualDestination, destination, "Actual destination and Expected destination do not match");

        // verify selected
        var datePicker = gobusForm.getTripChoiseDateComponent();
        datePicker.setDate(monthandYear, day);
        String actualDate = datePicker.getDate();
        Assert.assertEquals(actualDate, date, "actual date and expected date do not match");

        // verify set seats count
        var seatsCountComponent = gobusForm.getSeatsCountComponent();
        seatsCountComponent.setSeatsCount(numberOfSeats);
        String ActualCount = seatsCountComponent.getSeatsCount();
        Assert.assertEquals(ActualCount, numberOfSeats, "\nActual count and Expected count do not match\n" +
                "Actual : ("+ ActualCount +" ) , Expected : (" + numberOfSeats +")\n");

        // verify go to the Page of Trip
        var tripPage = gobusForm.goToTripsPage();
        tripPage.isTripInfoHeaderDisplayed();


    }


}
