package com.muzima.ft.page_object;

import com.muzima.ft.Muzima;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CohortWizard {
  private AndroidDriver<AndroidElement> driver;

  public CohortWizard(AndroidDriver<AndroidElement> driver) {
    this.driver = driver;
  }

  public CohortWizard selectCDMCohort() {
    driver
      .findElement(By.name("CDM Cohort (5)"))
      .click();
    return this;
  }

  public CohortWizard downloadSelectedCohorts() {
    driver
      .findElement(By.name("Next"))
      .click();
    return this;
  }

  public FormTemplates waitForFormTemplatesToLoad() {
    new WebDriverWait(driver, Muzima.TIME_OUT_IN_SECONDS)
      .until(ExpectedConditions
        .elementToBeClickable(By.name("Step 2: Download Form Template(s)")));
    return new FormTemplates(driver);
  }

}
