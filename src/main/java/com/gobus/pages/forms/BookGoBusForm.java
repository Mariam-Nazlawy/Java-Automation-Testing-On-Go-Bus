package com.gobus.pages.forms;

import com.gobus.pages.base.HomePage;
import com.gobus.pages.formComponents.SeatsCountComponent;
import com.gobus.pages.formComponents.TripChoiseDateComponent;
import com.gobus.pages.formComponents.TripChoisePositionComponent;
import com.gobus.pages.formComponents.TripTypeSwitcherComponent;
import org.openqa.selenium.By;

public class BookGoBusForm extends HomePage {
    private By tripTypeSwitcher = By.xpath("//div[@class='tripType-switcher']");
    private By tripChoisePosition= By.xpath("//div[@class='trip-choise-con'][1]");
    private By tripChoiseDate = By.xpath("//div[@class='trip-choise-con'][2]");
    private By showTriosButton = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div/form/button");

     public TripTypeSwitcherComponent getTripTypeSwitcherComponent(){
         return new TripTypeSwitcherComponent();
     }

    public TripChoisePositionComponent getTripChoisePositionComponent(){
        return new TripChoisePositionComponent();
    }

    public TripChoiseDateComponent getTripChoiseDateComponent(){
        return new TripChoiseDateComponent();
    }

    public SeatsCountComponent getSeatsCountComponent(){
        return new SeatsCountComponent();
    }

    public  void clickshowTriosButton(){
         click(showTriosButton);
    }

}
