package com.muzima.ft.page_object;

import com.muzima.ft.Muzima;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Provider {
  private AndroidDriver<AndroidElement> driver;
  private Point location;

  public Provider(AndroidDriver<AndroidElement> driver) {
    this.driver = driver;
  }

  public Provider searchProvider() {
    AndroidElement providerAutocomplete = driver
      .findElement(By.name("Enter provider name ..."));
    location = providerAutocomplete.getLocation();
    providerAutocomplete.click();
    providerAutocomplete.sendKeys("vik");
    return this;
  }

  public Provider selectProvider() {
    driver.tap(1, location.getX() + 50, location.getY() + 50, 10);
    return this;
  }

  public Provider downloadSelectedProviders() {
    driver
      .findElement(By.name("Next"))
      .click();
    return this;
  }

  public Concepts waitForConceptsToLoad() {
    new WebDriverWait(driver, Muzima.TIME_OUT_IN_SECONDS)
      .until(ExpectedConditions
        .elementToBeClickable(By.name("Step 4: Add Concept(s)")));
    return new Concepts(driver);
  }

}
