package com.gobus.pages.book;

import com.gobus.pages.base.BasePage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class TripsPage extends BasePage {
  private By trips = By.xpath("//div[@class='list']");

  private By chooseTripButton = By.xpath("//div[@class='list'][2]/div[@class='list-con']/div[2]/div[1]/button");

  private By bookSeatsButton = By.xpath("//a[@class='btn']");

  private By tripInfoHeader = By.xpath("//div[@class=\"data-show-desktop\"]");

  private By getTripButton(int tripNum){
      return By.xpath("//div[@class='list']["+ tripNum +"]/div[@class='list-con']/div[2]/div[1]/button");
  }

  public void clickcChooseTripButton(int tripNum){
      click(getTripButton(tripNum));
  }

  public BookSeatsPage clickBookSeatsButton(){
      findElementUntilBeClickable(bookSeatsButton).click();
      return new BookSeatsPage();
  }

  public boolean isTripInfoHeaderDisplayed(){
     scrollToElementJS(tripInfoHeader);
      return find(tripInfoHeader).isDisplayed();
  }

}
