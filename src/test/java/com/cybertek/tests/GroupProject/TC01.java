package com.cybertek.tests.GroupProject;

import com.cybertek.tests.day05_xpath_css_isdisplayed.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC01 {

    public static void main(String[] args) throws InterruptedException {

        String url = "https://login.nextbasecrm.com/";

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get(url);

        String user = "helpdesk1@cybertekschool.com";
        String pass = "UserUser";

        WebElement loginInput = driver.findElement(By.cssSelector("input[name='USER_LOGIN']"));
        WebElement passInput = driver.findElement(By.cssSelector("input[name='USER_PASSWORD']"));

        loginInput.sendKeys(user);
        Thread.sleep(1500);

        passInput.sendKeys(pass);
        Thread.sleep(1500);

        WebElement loginButton = driver.findElement(By.cssSelector("input[value='Log In']"));
        loginButton.click();

        WebElement verifyUser = driver.findElement(By.cssSelector("span[id='user-name']"));

        String expUser = user;
        String actUser = verifyUser.getText();

        if (actUser.equals(expUser)) {
            System.out.println("PASS: User successfully logged in");
        } else {
            System.out.println("FAIL: User not logged in");
        }

    }

}
