package com.muzima.ft.page_object;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class Dashboard {
  private AndroidDriver<AndroidElement> driver;

  public Dashboard(AndroidDriver<AndroidElement> driver) {
    this.driver = driver;
  }

  public String getFormSyncStatus() {
    return driver.findElements(By.className("android.widget.TextView")).get(5).getText();
  }

  public String getCohortSyncStatus() {
    return driver.findElements(By.className("android.widget.TextView")).get(3).getText();
  }

}
