package tests.loginTests;

import base.BaseTest;
import com.gobus.pages.base.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.gobus.pages.forms.LoginOptionsForm.getErrorMessage;
import static com.gobus.pages.forms.MyAccount.isHeaderDisplayed;

public class LoginTest extends BaseTest {
    private String email = "maryamnzlawy@gmail.com";
    private String password = "gobus-secret";

    // test with valid cardinalities
    @Test
    public void testLogin() {
        var loginUsingEmail = HomePage.goToLoginOptionsForm().goTologinWithEmail();

        loginUsingEmail.logintoGoBus(email, password);
        Assert.assertTrue(isHeaderDisplayed());

    }

}
