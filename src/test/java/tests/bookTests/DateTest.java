package tests.bookTests;

import base.BaseTest;
import com.gobus.pages.base.HomePage;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import utilities.ReadXLSFile;

public class DateTest extends BaseTest {
    @Test(dataProvider = "testdata" ,dataProviderClass = ReadXLSFile.class)
    public void testDateselection(String date, String monthandYear, String day){
        var datePicker = HomePage.accessBookGoBus().getTripChoiseDateComponent();

        datePicker.setDate(monthandYear, day);
        String actualDate = datePicker.getDate();
        Assert.assertEquals(actualDate, date, "actual date and expected date do not match");
    }
}
