package com.qa.pages;

import com.qa.listeners.ExtentReportListener;
import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Listeners({ExtentReportListener.class})
public class LoginPage extends TestBase {
    @FindBy(name="uname")
    WebElement username;

    @FindBy(name="psw")
    WebElement password;

    @FindBy(tagName = "button")
    WebElement loginButton;


    public LoginPage() throws IOException {
        PageFactory.initElements(driver, this);
    }

    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public DashboardPage login(String uname, String pass) throws IOException, InterruptedException {
        username.sendKeys(uname);
        password.sendKeys(pass);
        loginButton.click();
        TimeUnit.SECONDS.sleep(10);
        return new DashboardPage();
    }
}
