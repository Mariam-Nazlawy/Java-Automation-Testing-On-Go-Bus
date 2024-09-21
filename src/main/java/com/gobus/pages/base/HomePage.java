package com.gobus.pages.base;

import com.gobus.pages.forms.BookGoBusForm;
import com.gobus.pages.forms.LoginOptionsForm;
import org.openqa.selenium.By;


public class HomePage extends BasePage {
    private static By loginButton = By.xpath("//button[@class='btn login-btn']");
    private static By travelDestination;
    private static By goBusStations;
    private static By bookGoBusForm = By.xpath("//div[@id='bus']");


    public static LoginOptionsForm goToLoginOptionsForm(){
        click(loginButton);
        return new LoginOptionsForm();
    }

    public static BookGoBusForm accessBookGoBus(){
        return new BookGoBusForm();
    }


}
