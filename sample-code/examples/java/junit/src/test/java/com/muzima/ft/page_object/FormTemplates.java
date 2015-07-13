package com.muzima.ft.page_object;

import com.muzima.ft.Muzima;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormTemplates {
  private AndroidDriver<AndroidElement> driver;

  public FormTemplates(AndroidDriver<AndroidElement> driver) {
    this.driver = driver;
  }

  public FormTemplates scrollDownToRegistrationForm() {
    driver.scrollTo("mUzima Registration Form v0.01 (mUzima form)");
    return this;
  }

  public FormTemplates selectRegistrationForm() {
    driver
      .findElement(By.name("mUzima Registration Form v0.01 (mUzima form)"))
      .click();
    return this;
  }

  public FormTemplates downloadSelectedFormTemplates() {
    driver
      .findElement(By.name("Next"))
      .click();
    return this;
  }

  public Location waitForLocationsToLoad() {
    new WebDriverWait(driver, Muzima.TIME_OUT_IN_SECONDS)
      .until(ExpectedConditions
        .elementToBeClickable(By.name("Step 3: Add Location(s)")));
    return new Location(driver);
  }

}
