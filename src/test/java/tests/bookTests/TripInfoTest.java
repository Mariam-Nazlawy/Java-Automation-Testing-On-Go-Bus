package tests.bookTests;

import base.BaseTest;
import com.gobus.pages.base.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TripInfoTest extends BaseTest {
    @Test
    public void testTripInfo(){
        var tripSwitcher = HomePage.accessBookGoBus().getTripTypeSwitcherComponent();
        var position = HomePage.accessBookGoBus().getTripChoisePositionComponent();
        var datePicker = HomePage.accessBookGoBus().getTripChoiseDateComponent();
        var seatsCountComponent = HomePage.accessBookGoBus().getSeatsCountComponent();


        // Place Info
        String source = "Cairo";
        String station = "Cairo ( Tahrir )";
        String destination = "Alexandria (Moharam BK)";

        // Date Info
        String date = "Thu 12 December  2024";
        String monthandYear = "December 2024";
        String day = "12";

        // number of seats
        String numberOfSeats = "2";

        // Test switching to One Way (assuming one-way is default)
        Assert.assertTrue(tripSwitcher.isOneWaySelected(), "One Way should be selected by default");


        // verify source selection
        position.selectSourceStation(source, station);
        String actualStation = position.getSource();
        Assert.assertEquals(actualStation, station, "Actual Source and Expected Source do not match");

        // verify destination selection
        position.selectDestination(destination);
        String actualDestination = position.getDestination();
        Assert.assertEquals(actualDestination, destination, "Actual destination and Expected destination do not match");

        // verify selected date
        datePicker.setDate(monthandYear, day);
        String actualDate = datePicker.getDate();
        Assert.assertEquals(actualDate, date, "actual date and expected date do not match");

        // verify set seats count
        seatsCountComponent.setSeatsCount(numberOfSeats);
        String ActualCount = seatsCountComponent.getSeatsCount();
        Assert.assertEquals(ActualCount, numberOfSeats, "\nActual count and Expected count do not match\n" +
                "Actual : ("+ ActualCount +" ) , Expected : (" + numberOfSeats +")\n");

        // verify go to the Page of Trip
        var tripPage = HomePage.accessBookGoBus().goToTripsPage();
        tripPage.isTripInfoHeaderDisplayed();


    }


}
