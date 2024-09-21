package com.gobus.pages.forms;

import com.gobus.pages.base.HomePage;
import org.openqa.selenium.By;

public class MyAccount extends HomePage {
private static By MyAccountHeader = By.xpath("//*[@id=\"root\"]/div/div/div[1]/header/div[2]/div/div[3]/div[1]/div[1]/h4");

public static boolean isHeaderDisplayed(){
    return findElementUntilBeVisible(MyAccountHeader).isDisplayed();
}

}
