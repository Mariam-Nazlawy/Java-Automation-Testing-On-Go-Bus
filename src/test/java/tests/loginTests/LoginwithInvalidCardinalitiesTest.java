package tests.loginTests;

import base.BaseTest;
import com.gobus.pages.base.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.gobus.pages.forms.LoginOptionsForm.getErrorMessage;


public class LoginwithInvalidCardinalitiesTest extends BaseTest {
    private String email = "wefew@example.com";
    private String password = "gobus-secret";

    
    // test with invalid cardinalities
    @Test void testLoginWithInvalidCard(){
        var loginUsingEmail = HomePage.goToLoginOptionsForm().goTologinWithEmail();

        loginUsingEmail.logintoGoBus(email, password);
        String errorMessage = getErrorMessage();
        Assert.assertTrue(errorMessage.contains("went wrong"));
    }
}
