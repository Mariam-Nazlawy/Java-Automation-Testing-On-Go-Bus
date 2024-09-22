package com.gobus.pages.base;

import com.gobus.pages.forms.BookGoBusForm;
import com.gobus.pages.forms.LoginOptionsForm;
import org.openqa.selenium.By;


public class HomePage extends BasePage {
    private static By loginButton = By.xpath("//button[@class='btn login-btn']");
    private static By travelDestination = By.xpath("//*[@id=\"root\"]/div/div/div[1]/header/div[2]/div/div[2]/div[2]/ul/li[2]/a");
    private static By goBusStations = By.xpath("//*[@id=\"root\"]/div/div/div[1]/header/div[2]/div/div[2]/div[2]/ul/li[3]/a");
    private static By bookGoBusForm = By.xpath("//div[@id='bus']");


    public static LoginOptionsForm goToLoginOptionsForm(){
        click(loginButton);
        return new LoginOptionsForm();
    }

    public static BookGoBusForm accessBookGoBus(){
        return new BookGoBusForm();
    }

    public static travelDestinationPage goToTravelDestinationPage(){
        click(travelDestination);
        return new travelDestinationPage();
    }

    public static goBusStationsPage goTogoBusStationsPage(){
        click(goBusStations);
        return new goBusStationsPage();
    }


}
