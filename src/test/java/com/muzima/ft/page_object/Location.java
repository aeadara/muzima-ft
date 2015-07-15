package com.muzima.ft.page_object;

import com.muzima.ft.Muzima;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Location {
  private AndroidDriver<AndroidElement> driver;
  private Point locationPoint;

  public Location(AndroidDriver<AndroidElement> driver) {
    this.driver = driver;
  }

  public Location searchLocation() {
    AndroidElement locationAutocomplete = driver
      .findElement(By.name("Enter location name ..."));
    locationPoint = locationAutocomplete.getLocation();
    locationAutocomplete.click();
    locationAutocomplete.sendKeys("mos");
    return this;
  }

  public Location selectLocation() {
    driver.tap(1, locationPoint.getX() + 50, locationPoint.getY() + 100, 10);
    return this;
  }

  public Location downloadSelectedLocations() {
    driver
      .findElement(By.name("Next"))
      .click();
    return this;
  }

  public Provider waitForProvidersToLoad() {
    new WebDriverWait(driver, Muzima.TIME_OUT_IN_SECONDS)
      .until(ExpectedConditions
        .elementToBeClickable(By.name("Step 3: Add Provider(s)")));
    return new Provider(driver);
  }
}
