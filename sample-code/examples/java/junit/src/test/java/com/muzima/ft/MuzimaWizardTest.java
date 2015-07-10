package com.muzima.ft;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;

import static org.junit.Assert.assertEquals;

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
  public void shouldAllowDataToBeDownloadedWhenRunningWizard() throws InterruptedException {
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

    //Add Location
    new WebDriverWait(driver, 30)
      .until(ExpectedConditions
        .elementToBeClickable(By.name("Step 3: Add Location(s)")));
    AndroidElement locationAutocomplete = driver
      .findElement(By.name("Enter location name ..."));
    Point locationPoint = locationAutocomplete.getLocation();
    locationAutocomplete.click();
    locationAutocomplete.sendKeys("mos");
    driver.tap(1, locationPoint.getX() + 50, locationPoint.getY() + 100, 10);
    driver
      .findElement(By.name("Next"))
      .click();

    //Add Location
    new WebDriverWait(driver, 30)
      .until(ExpectedConditions
        .elementToBeClickable(By.name("Step 3: Add Provider(s)")));
    AndroidElement providerAutocomplete = driver
      .findElement(By.name("Enter provider name ..."));
    Point providerAutocompleteLocation = providerAutocomplete.getLocation();
    providerAutocomplete.click();
    providerAutocomplete.sendKeys("vik");
    driver.tap(1, providerAutocompleteLocation.getX() + 50, providerAutocompleteLocation.getY() + 50, 10);
    driver
      .findElement(By.name("Next"))
      .click();


    //Add Concept
    new WebDriverWait(driver, 30)
      .until(ExpectedConditions
        .elementToBeClickable(By.name("Step 4: Add Concept(s)")));
    AndroidElement conceptAutocomplete = driver
      .findElement(By.name("Enter concept name ..."));
    Point conceptAutocompleteLocation = conceptAutocomplete.getLocation();
    conceptAutocomplete.click();
    conceptAutocomplete.sendKeys("vik");
    driver.tap(1, conceptAutocompleteLocation.getX() + 50, conceptAutocompleteLocation.getY() + 50, 10);
    driver
      .findElement(By.name("Next"))
      .click();

    //Skip barcode scanner
    new WebDriverWait(driver, 30)
      .until(ExpectedConditions
        .elementToBeClickable(By.name("Step 5: Check for BarCode Scanner")));
    driver
      .findElement(By.name("Skip"))
      .click();

    //Run verifications on Dashboard
    new WebDriverWait(driver, 30)
      .until(ExpectedConditions
        .elementToBeClickable(By.name("mUzima Clinic")));
    AndroidElement cohortStatus = driver.findElements(By.className("android.widget.TextView")).get(3);
    assertEquals("1 Synced, 8 Total", cohortStatus.getText());
    AndroidElement formStatus = driver.findElements(By.className("android.widget.TextView")).get(5);
    assertEquals("5 Synced", formStatus.getText());
  }
}
