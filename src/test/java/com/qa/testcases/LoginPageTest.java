package com.qa.testcases;

import com.aventstack.extentreports.Status;
import com.qa.base.ExtentTestManager;
import com.qa.listeners.ExtentReportListener;
import com.qa.base.TestBase;
import com.qa.pages.DashboardPage;
import com.qa.pages.LoginPage;

import com.qa.utils.Log;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

@Listeners({ExtentReportListener.class})
public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    public LoginPageTest() throws IOException {
        // using super keyword b/c before initialization method, we need to init properties as well in test base
        super();
    }

//    @BeforeMethod
    @BeforeClass
    public void setup() {
        initialization(); // from test base
        try {
            loginPage = new LoginPage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    public void loginPageTitleTest(){
        Log.info("helloo");
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, properties.getProperty("loginPageTitle"), "Login Page did not open");
    }


    @Test(priority = 2)
     public void loginTest() throws IOException, InterruptedException {
        ExtentTestManager.getTest().log(Status.INFO, "Hellooo started base test2");
        System.out.println("Hey im in test2 test");
        Thread.sleep(3000);
        ExtentTestManager.getTest().log(Status.INFO, "Hey im in base test2 1");
        ExtentTestManager.getTest().log(Status.INFO, "Hey im in base test2 2");
        // saving into dashboard object
        dashboardPage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
     }




//     @AfterMethod
    @AfterClass
     public void tearDown(){
        driver.quit();
     }
}
