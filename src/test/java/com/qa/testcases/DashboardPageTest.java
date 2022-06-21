package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pages.DashboardPage;
import com.qa.pages.LoginPage;
import com.qa.pages.PersonalInformationPage;
import com.qa.utils.Log;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.io.IOException;

public class DashboardPageTest extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    PersonalInformationPage personalInformationPage;

    public DashboardPageTest() throws IOException {
        super();
    }

//    @BeforeMethod
    @BeforeClass
    public void setup() throws IOException, InterruptedException {
        initialization();
        loginPage = new LoginPage();
        dashboardPage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
//        personalInformationPage = new PersonalInformationPage();
    }

    @Test(priority = 1)
    public void verifyDashboardPageTitle(Method method) {
        String dashboardPageTitle = dashboardPage.validateDashboardPageTitle();
        Assert.assertEquals(dashboardPageTitle, properties.getProperty("dashboardPageTitle"), "Dashboard did not open");
    }

//    @Test(priority = 1)
//    public void personalInformationPage() throws IOException, InterruptedException {
//        dashboardPage.clickOnPersonalInfo();
//    }

//    @AfterMethod
     @AfterClass
     public void tearDown(){
        driver.quit();
     }
}
