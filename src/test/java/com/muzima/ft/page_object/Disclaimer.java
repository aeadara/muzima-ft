package com.muzima.ft.page_object;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class Disclaimer {
  private AndroidDriver<AndroidElement> driver;

  public Disclaimer(AndroidDriver<AndroidElement> driver) {
    this.driver = driver;
  }

  public Disclaimer readTermsAndConditions() {
    driver.scrollTo("Indiana University");
    return this;
  }

  public Login agreeToTermsAndConditions() {
    driver.findElement(By.name("Agree"))
      .click();
    return new Login(driver);
  }
}
