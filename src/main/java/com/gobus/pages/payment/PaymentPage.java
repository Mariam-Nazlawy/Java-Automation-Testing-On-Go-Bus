package com.gobus.pages.payment;

import com.gobus.pages.base.BasePage;
import org.openqa.selenium.By;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class PaymentPage extends BasePage {

    private By payOnlineHeader = By.xpath("//div[@class=\"widget-head\"]/h3[text()='Pay Online']");

    public boolean ispayOnlineHeaderDisplyed(){
        scrollToElementJS(payOnlineHeader);
        return findElementUntilBeVisible(payOnlineHeader).isDisplayed();
    }
}
