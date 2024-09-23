package com.gobus.pages.book;

import com.gobus.pages.base.BasePage;
import com.gobus.pages.payment.PaymentPage;
import org.openqa.selenium.By;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class BookSeatsPage extends BasePage {
    private By checkAvailabilityButton =  By.xpath("//button[text()='Check Availability']");


    public PaymentPage clickcheckAvailabilityButton(){
        scrollToElementJS(checkAvailabilityButton);
        findElementUntilBeClickable(checkAvailabilityButton).click();
        return new PaymentPage();
    }

    public boolean ischeckAvailabilityButtonDisplayed(){
        scrollToElementJS(checkAvailabilityButton);
        return findElementUntilBeClickable(checkAvailabilityButton).isDisplayed();
    }


}
