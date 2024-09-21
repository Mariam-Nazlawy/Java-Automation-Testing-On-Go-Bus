package com.gobus.pages.forms;

import com.gobus.pages.base.BasePage;
import com.gobus.pages.base.HomePage;
import org.openqa.selenium.By;

public class LoginOptionsForm extends HomePage {
    private By loginUsingEmail = By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div/div/div/div/button");
    private By loginUsingFacebook;
    private By register;
    protected static By errorMessage = By.xpath("//form[@class='login-form active']//h4[2]//div//p");

    public EmailLoginForm goTologinWithEmail(){
        click(loginUsingEmail);
        return new EmailLoginForm();
    }

    public static String getErrorMessage(){
        return findElementUntilBeVisible(errorMessage).getText();
    }

}
