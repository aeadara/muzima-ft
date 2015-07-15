package com.muzima.ft.page_object;

import com.muzima.ft.Muzima;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BarcodeScanner {
  private AndroidDriver<AndroidElement> driver;

  public BarcodeScanner(AndroidDriver<AndroidElement> driver) {
    this.driver = driver;
  }

  public BarcodeScanner skipBarcodeScanner() {
    driver
      .findElement(By.name("Skip"))
      .click();
    return this;
  }

  public Dashboard waitForDashboardToLoad() {
    new WebDriverWait(driver, Muzima.TIME_OUT_IN_SECONDS)
      .until(ExpectedConditions
        .elementToBeClickable(By.name("mUzima Clinic")));
    return new Dashboard(driver);
  }
}
