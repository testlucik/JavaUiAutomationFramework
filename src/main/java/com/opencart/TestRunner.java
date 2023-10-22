package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        String currentWindowName = driver.getWindowHandle();

        //New Window Code
        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://opencart.antropy.co.uk/");


        WebElement myAccountIcon = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        myAccountIcon.click();

        WebElement registerOption = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        registerOption.click();

        System.out.println(driver.getCurrentUrl());

        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        WebElement lastNameInput = driver.findElement(By.cssSelector("#input-lastname"));
        WebElement emailInput = driver.findElement(By.cssSelector("#input-email"));
        WebElement phoneInput = driver.findElement(By.cssSelector("#input-telephone"));
        WebElement passwordInput = driver.findElement(By.cssSelector("#input-password"));
        WebElement confirmPasswordInput = driver.findElement(By.cssSelector("#input-confirm"));
        WebElement termsAndConditionsCheckbox = driver.findElement(By.xpath("//input[@name='agree']"));
        WebElement registerBtn = driver.findElement(By.xpath("//input[@value='Continue']"));


        String firstName = RandomDataManager.generateFirstName();
        firstNameInput.sendKeys(firstName);
        System.out.println(firstName);
        String lastName = RandomDataManager.generateLastName();
        lastNameInput.sendKeys(lastName);
        System.out.println(lastName);
        String email = RandomDataManager.generateRandomEmail();
        emailInput.sendKeys(email);
        System.out.println(email);
        phoneInput.sendKeys(RandomDataManager.generatePhoneNumber());

        String password = RandomDataManager.generatePassword();
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(password);
        System.out.println(password);
        termsAndConditionsCheckbox.click();
        registerBtn.click();


        Thread.sleep(5000);
        System.out.println(driver.getTitle());
        driver.close();

        driver.switchTo().window(currentWindowName);
        driver.get("https://www.tekwill.md/");
        Thread.sleep(1000);
        System.out.println(driver.getTitle());
        driver.quit();
        System.out.println("The execution is over");


    }
}