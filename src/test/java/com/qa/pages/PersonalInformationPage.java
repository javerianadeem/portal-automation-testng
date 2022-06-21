package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PersonalInformationPage extends TestBase {

    @FindBy(xpath = "//div[@id='mat-tab-label-0-1']")
    WebElement skillTab;

    @FindBy(xpath = "//span[@class='custom-icons sys-icon-edit'][1]")
    WebElement editSkillButton;

    @FindBy(id = "input-autofocus")
    WebElement skillInput;

    @FindBy(xpath = "//span[@class='mat-button-wrapper'] [contains(text(), 'Save')]")
    WebElement saveSkillButton;

    @FindBy(className = "skill-name")
    List<WebElement> employeeSkills;

    public PersonalInformationPage() throws IOException {
        PageFactory.initElements(driver,this);
    }

    public String validatePersonalInfoPageTitle(){
        return driver.getTitle();
    }

    public void addSkill(String skillName) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        skillTab.click();
        TimeUnit.SECONDS.sleep(2);
        editSkillButton.click();
        skillInput.sendKeys(skillName.toLowerCase());
        TimeUnit.SECONDS.sleep(1);
        skillInput.sendKeys(Keys.ENTER);
        saveSkillButton.click();
        TimeUnit.SECONDS.sleep(4);
    }

    public boolean verifySkill(String skillName) {
        skillTab.click();
        for (WebElement skill : employeeSkills) {
//            System.out.println(skill.getText());
//            System.out.println("strings " + skill.getText().toLowerCase() + skillName);
            if (skill.getText().toLowerCase().equals(skillName.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

}