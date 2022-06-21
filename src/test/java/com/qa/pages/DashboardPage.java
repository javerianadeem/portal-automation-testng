package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DashboardPage extends TestBase{

    @FindBy(xpath = "//img[@src='https://syshcm.visionetsystems.com/Logo/systems.png']")
    WebElement systemsImageLogo;

    @FindBy(id = "routeLink")
    List<WebElement> sidebarLinks;

    @FindBy(xpath = "//a[@href='/EssPlus/personal-information']")
    WebElement pInfoLink;

    public DashboardPage() throws IOException {
        PageFactory.initElements(driver,this);
    }
    public String validateDashboardPageTitle(){
        return driver.getTitle();
    }

    public PersonalInformationPage clickOnPersonalInfo() throws IOException, InterruptedException {
//        WebElement personalInformation = sidebarLinks.get(sidebarLinks.size() -1);
//        System.out.println("pinfo" + personalInformation);
//        personalInformation.click();
        driver.get(properties.getProperty("url") + "/personal-information");
//        pInfoLink.click();
        TimeUnit.SECONDS.sleep(10);
        return new PersonalInformationPage();
    }


}
