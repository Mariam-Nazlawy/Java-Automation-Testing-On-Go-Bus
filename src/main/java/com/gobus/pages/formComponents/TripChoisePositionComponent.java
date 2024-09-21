package com.gobus.pages.formComponents;

import com.gobus.pages.base.BasePage;
import org.openqa.selenium.By;

public class TripChoisePositionComponent extends BasePage {

    private By source = By.xpath("//*[@id=\"bus\"]/div[2]/div[1]/div/div[1]/span");

    private By sourceMenue = By.xpath("//*[@id=\"bus\"]/div[2]/div[1]/div/div[1]");

    private By destinationMenue = By.xpath("//*[@id=\"bus\"]/div[2]/div[2]/div/div[1]");

    private By destination = By.xpath("//*[@id=\"bus\"]/div[2]/div[2]/div/div[1]/span");


    private By sourceValue(String source){
        return By.xpath("//*[@id=\"bus\"]/div[2]/div[1]/div/div[2]/ul[1]/li[text()='"+ source +"']");
    }


    private By stationValue(String station){
        return By.xpath("//ul[@class=\"browse-select-options subgroup active\"]/li[text()='"+ station +"']");
    }


    private By destinationValue(String detination){
        return By.xpath("//*[@id=\"bus\"]/div[2]/div[2]/div/div[2]/ul/li[text()='"+ detination +"']");
    }


    public void selectSourceStation(String source, String station){
         click(sourceMenue);
         click(sourceValue(source));
         click(stationValue(station));
    }



    public void selectDestination(String destination){
        click(destinationMenue);
        click(destinationValue(destination));
    }


    public String getSource(){
      return getText(source);
    }


   public String getDestination(){
        return getText(destination);
    }


//    public boolean compareSource(){
//
//    }
//
//
//    public boolean compareDestination(){
//
//    }

    
}
