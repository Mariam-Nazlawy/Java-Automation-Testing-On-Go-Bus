package tests.bookTests;

import base.BaseTest;
import com.gobus.pages.base.HomePage;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DateTest extends BaseTest {
    @Test
    public void testDateselection(){
        var datePicker = HomePage.accessBookGoBus().getTripChoiseDateComponent();
        String date = "Thu 12 December  2024";
        String monthandYear = "December 2024";
        String day = "12";


        datePicker.setDate(monthandYear, day);
        String actualDate = datePicker.getDate();
        Assert.assertEquals(actualDate, date, "actual date and expected date do not match");
    }
}
