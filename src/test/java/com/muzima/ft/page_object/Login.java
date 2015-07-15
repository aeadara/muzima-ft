package com.muzima.ft.page_object;

import com.muzima.ft.Muzima;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
  private AndroidDriver<AndroidElement> driver;

  public Login(AndroidDriver<AndroidElement> driver) {
    this.driver = driver;
  }

  public Login enterUsername() {
    AndroidElement username = driver.findElement(By.name("Username"));
    username.click();
    username.sendKeys("admin");
    return this;
  }

  public Login enterPassword() {
    driver.scrollTo("Login");
    AndroidElement password = driver.findElements(By.className("android.widget.EditText")).get(2);
    password.click();
    password.sendKeys("test");
    return this;
  }

  public Login login() {
    driver
      .findElement(By.name("Login"))
      .click();
    return this;
  }

  public CohortWizard waitForCohortsToLoad() {
    new WebDriverWait(driver, Muzima.TIME_OUT_IN_SECONDS)
      .until(ExpectedConditions
        .elementToBeClickable(By.name("CDM Cohort (5)")));
    return new CohortWizard(driver);
  }

}
