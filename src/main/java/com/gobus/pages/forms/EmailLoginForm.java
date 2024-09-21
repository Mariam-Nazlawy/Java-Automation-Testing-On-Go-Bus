package com.gobus.pages.forms;

import com.gobus.pages.base.BasePage;
import org.openqa.selenium.By;

public class EmailLoginForm extends LoginOptionsForm {
    private By emailField = By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div/div/div/form/div[1]/input");
    private By passwordField = By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div/div/div/form/div[2]/input");
    private By loginButton = By.xpath("//button[@type='submit']");

    public void setEmail(String email){
        set(emailField, email);
    }

    public void setPassword(String password){
        set(passwordField, password);
    }

    public MyAccount clickLoginButton(){
        click(loginButton);
        return new MyAccount();
    }

    public MyAccount logintoGoBus(String email, String password) {
        setEmail(email);
        setPassword(password);
        return clickLoginButton();
    }

}
