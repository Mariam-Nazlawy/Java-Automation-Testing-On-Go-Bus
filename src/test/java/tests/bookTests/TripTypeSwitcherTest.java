package tests.bookTests;

import base.BaseTest;
import com.gobus.pages.base.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TripTypeSwitcherTest extends BaseTest {
    @Test
   public void testTripTypeSwitcher(){
        var tripSwitcher = HomePage.accessBookGoBus().getTripTypeSwitcherComponent();

        // Verify initial state (assuming One Way is default)
        Assert.assertTrue(tripSwitcher.isOneWaySelected(), "One Way should be selected by default");

        // Test switching to Round Trip
        tripSwitcher.clickRoundTripRadioBtn();
        Assert.assertTrue(tripSwitcher.isRoundTripSelected(), "Round Trip is not selected after clicking Round Trip radio button");
        Assert.assertFalse(tripSwitcher.isOneWaySelected(), "One Way should not be selected when Round Trip is active");

        // Test switching back to One Way
        tripSwitcher.clickOneWayRadioBtn();
        Assert.assertTrue(tripSwitcher.isOneWaySelected(), "One Way is not selected after clicking One Way radio button");
        Assert.assertFalse(tripSwitcher.isRoundTripSelected(), "Round Trip should not be selected when One Way is active");

    }
}
