package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pages.DashboardPage;
import com.qa.pages.LoginPage;
import com.qa.pages.PersonalInformationPage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PersonalInformationPageTest extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    PersonalInformationPage personalInformationPage;

    public PersonalInformationPageTest() throws IOException {
    }

//    @BeforeMethod
    @BeforeClass
    public void setup() throws IOException, InterruptedException {
        initialization();
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        personalInformationPage = new PersonalInformationPage();
        dashboardPage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
        TimeUnit.SECONDS.sleep(5);
    }

    @BeforeMethod
    public void openPersonalInfoPage() throws IOException, InterruptedException {
        personalInformationPage = dashboardPage.clickOnPersonalInfo();
        TimeUnit.SECONDS.sleep(3);
    }

    @Test(priority = 1)
    public void verifyPersonalInformationPageTitle(){
        String title = personalInformationPage.validatePersonalInfoPageTitle();
        Assert.assertEquals(title, properties.getProperty("personalInformationPageTitle"), "Personal Info page did not open");
    }

    @Test(enabled = false,priority = 2)
    public void addSkill() throws InterruptedException {
        personalInformationPage.addSkill(properties.getProperty("skillName"));
    }

    @Test(priority = 3)
    public void verifySkill(){
        boolean response = personalInformationPage.verifySkill(properties.getProperty("skillName"));
        if (response == true) {
            System.out.println(properties.getProperty("skillName") + " as a skill is added");
        } else if (!response) {
            System.out.println(properties.getProperty("skillName") + " as a skill is not added");
            Assert.assertTrue(false);
        }
    }

//    @AfterMethod
    @AfterClass
     public void tearDown(){
        driver.quit();
     }
}
