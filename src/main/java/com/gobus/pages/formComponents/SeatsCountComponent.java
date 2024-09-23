package com.gobus.pages.formComponents;

import com.gobus.pages.base.BasePage;
import com.gobus.pages.forms.BookGoBusForm;
import org.openqa.selenium.By;

public class SeatsCountComponent extends BasePage {

    private By incrementalButton = By.xpath("//button[@class='seat-inc-btn']");
    private By deccrementalButton = By.xpath("//button[@class='seat-dec-btn']");
    private By seatsCount = By.xpath("//div[@class='seat-selector-default home']//span");

    private String maxNumOfSeats = "8";

    private String minNumOfSeats = "1";


    public void increaseSeatsByOne(){
        click(incrementalButton);
    }

    public void decreaseSeatsByOne(){
        click(deccrementalButton);
    }

    public String getSeatsCount(){
        return getText(seatsCount);
    }

    public void setSeatsCount(String numOfSeats){
        int numofSeats = Integer.parseInt(numOfSeats);
        for(int i = 1; i < numofSeats; i++){
            click(incrementalButton);
        }
    }

    public boolean isExceededMaxCount(int maxNumofSeats){

        for(int i = 1; i <= maxNumofSeats; i++){
            click(incrementalButton);
        }
        return !getSeatsCount().equals(maxNumOfSeats);
    }



}
