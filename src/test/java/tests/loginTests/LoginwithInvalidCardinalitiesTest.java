package tests.loginTests;

import base.BaseTest;
import com.gobus.pages.base.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReadXLSFile;

import static com.gobus.pages.forms.LoginOptionsForm.getErrorMessage;


public class LoginwithInvalidCardinalitiesTest extends BaseTest {
    
    // test with invalid cardinalities
    @Test(dataProvider = "testdata" ,dataProviderClass = ReadXLSFile .class)
     public void testLoginWithInvalidCard(String email, String password){
        var loginUsingEmail = HomePage.goToLoginOptionsForm().goTologinWithEmail();

        loginUsingEmail.logintoGoBus(email, password);
        String errorMessage = getErrorMessage();
        Assert.assertTrue(errorMessage.contains("went wrong"));
    }
}
