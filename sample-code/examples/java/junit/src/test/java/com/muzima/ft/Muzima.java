package com.muzima.ft;

import com.muzima.ft.page_object.Disclaimer;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Muzima {

  public static final int TIME_OUT_IN_SECONDS = 120;
  private AndroidDriver<AndroidElement> driver;
  private DesiredCapabilities capabilities;

  public void install() throws MalformedURLException {
    File classpathRoot = new File(System.getProperty("user.dir"));
    File appDir = new File(classpathRoot, "../../../../../muzima-android/target/");
    File app = new File(appDir, "muzima-android.apk");
    capabilities = new DesiredCapabilities();
    capabilities.setCapability("deviceName", "Android Emulator");
    capabilities.setCapability("platformVersion", "4.4");
    capabilities.setCapability("app", app.getAbsolutePath());
    capabilities.setCapability("appPackage", "com.muzima");
  }

  public void quit() {
    driver.quit();
  }

  public Disclaimer start() throws MalformedURLException {
    driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    return new Disclaimer(driver);
  }
}
