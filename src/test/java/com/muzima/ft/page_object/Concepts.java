package com.muzima.ft.page_object;

import com.muzima.ft.Muzima;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Concepts {
  private AndroidDriver<AndroidElement> driver;
  private Point location;

  public Concepts(AndroidDriver<AndroidElement> driver) {
    this.driver = driver;
  }

  public Concepts searchConcept() {
    AndroidElement conceptAutocomplete = driver
      .findElement(By.name("Enter concept name ..."));
    location = conceptAutocomplete.getLocation();
    conceptAutocomplete.click();
    conceptAutocomplete.sendKeys("vik");
    return this;
  }

  public Concepts selectConcept() {
    driver.tap(1, location.getX() + 50, location.getY() + 50, 10);
    return this;
  }

  public Concepts downloadSelectedConcepts() {
    driver
      .findElement(By.name("Next"))
      .click();
    return this;
  }

  public BarcodeScanner waitForBarcodeScannerToLoad() {
    new WebDriverWait(driver, Muzima.TIME_OUT_IN_SECONDS)
      .until(ExpectedConditions
        .elementToBeClickable(By.name("Step 5: Check for BarCode Scanner")));
    return new BarcodeScanner(driver);
  }

}
