package com.gobus.pages.formComponents;

import com.gobus.pages.forms.BookGoBusForm;
import org.openqa.selenium.By;

public class TripTypeSwitcherComponent extends BookGoBusForm {

    private By oneWayRadioBtn = By.xpath("//*[@id=\"bus\"]/div[1]/label[1]");

    private By roundTripRadioBtn = By.xpath("//*[@id=\"bus\"]/div[1]/label[2]");


    public void clickOneWayRadioBtn(){
        findElementUntilBeVisible(oneWayRadioBtn).click();
    }

    public void clickRoundTripRadioBtn(){
        findElementUntilBeVisible(roundTripRadioBtn).click();
    }

    public boolean isOneWaySelected(){
        return getRoundTripText().contains("DISCOUNT");
    }

    public boolean isRoundTripSelected(){
        return !getRoundTripText().contains("DISCOUNT");
    }

    public String getRoundTripText(){
        return getText(roundTripRadioBtn);
    }

}
