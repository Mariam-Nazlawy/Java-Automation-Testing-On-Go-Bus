package tests.loginTests;

import base.BaseTest;
import com.gobus.pages.base.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReadXLSFile;

import static com.gobus.pages.forms.LoginOptionsForm.getErrorMessage;
import static com.gobus.pages.forms.MyAccount.isHeaderDisplayed;

public class LoginTest extends BaseTest {
    @Test(dataProvider = "testdata" ,dataProviderClass = ReadXLSFile.class)
    public static void testLogin(String email, String password) {
        var loginUsingEmail = HomePage.goToLoginOptionsForm().goTologinWithEmail();
        loginUsingEmail.logintoGoBus(email, password);
        Assert.assertTrue(isHeaderDisplayed());

    }

}
