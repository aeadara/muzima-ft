package com.muzima.ft;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;

public class MuzimaWizardTest {
  private AppiumDriver<AndroidElement> driver;

  @Before
  public void setUp() throws Exception {
    // set up appium
    File classpathRoot = new File(System.getProperty("user.dir"));
    File appDir = new File(classpathRoot, "../../../../../muzima-android/target/");
    File app = new File(appDir, "muzima-android.apk");
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("deviceName", "Android Emulator");
    capabilities.setCapability("platformVersion", "4.4");
    capabilities.setCapability("app", app.getAbsolutePath());
    capabilities.setCapability("appPackage", "com.muzima");
    driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
  }

  @Test
  public void runThroughWizard() throws InterruptedException {
    //Scroll terms and condition text
    driver.scrollTo("Indiana University");

    //Agree to terms and conditions
    driver.findElement(By.name("Agree"))
      .click();

    //Enter Username
    AndroidElement username = driver.findElement(By.name("Username"));
    username.click();
    username.sendKeys("admin");

    //Enter down to see login and password fields
    driver.scrollTo("Login");

    //Enter Password
    AndroidElement password = driver.findElements(By.className("android.widget.EditText")).get(2);
    password.click();
    password.sendKeys("test");

    //Login
    driver
      .findElement(By.name("Login"))
      .click();

    //Select cohort
    new WebDriverWait(driver, 30)
      .until(ExpectedConditions
        .elementToBeClickable(By.name("CDM Cohort (5)")));
    driver
      .findElement(By.name("CDM Cohort (5)"))
      .click();
    driver
      .findElement(By.name("Next"))
      .click();

    //Select form templates
    new WebDriverWait(driver, 30)
      .until(ExpectedConditions
        .elementToBeClickable(By.name("Step 2: Download Form Template(s)")));
    driver.scrollTo("mUzima Registration Form v0.01 (mUzima form)");
    driver
      .findElement(By.name("mUzima Registration Form v0.01 (mUzima form)"))
      .click();
    driver
      .findElement(By.name("Next"))
      .click();
  }
}
