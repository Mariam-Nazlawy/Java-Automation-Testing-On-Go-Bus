package com.gobus.pages.formComponents;

import com.gobus.pages.base.BasePage;
import org.openqa.selenium.By;

public class TripChoiseDateComponent extends BasePage {

    private By dateMenu = By.xpath("//*[@id=\"bus\"]/div[3]/div/div[1]/div/input[1]");

    private By monthandYear = By.xpath("//*[@id=\"bus\"]/div[3]/div/div[3]/div/div[2]/div/div[1]/div");

    private By nextMonthPicker = By.xpath("//*[@id=\"bus\"]/div[3]/div/div[3]/div/div[1]/span[2]");

    private By date = By.xpath("//*[@id=\"bus\"]/div[3]/div/div[1]/div/input[1]");

    public void clickDateMenu(){
        click(dateMenu);
    }

    public String getMonthandYear(){
         return getText(monthandYear);
    }

    public void selectMonthandYear(String monthAndYear){
        String currentMonthandYear = getMonthandYear();
        while(!currentMonthandYear.equals(monthAndYear)){
            click(nextMonthPicker);
            currentMonthandYear = getMonthandYear();
            if(currentMonthandYear.equals("January 2026")) break;
        }
    }

    private By dayValue(String day){
        return By.xpath("//div[@class='DayPicker-Day'][text()='"+ day +"']");
    }

    public void selectDay(String day){
        click(dayValue(day));
    }

    public void setDate(String monthandYear, String day){

        //select date menu
        clickDateMenu();

        //select month and year
        selectMonthandYear(monthandYear);

        //select day
        selectDay(day);
    }

    public String getDate(){
        return find(date).getAttribute("value");
    }











}
