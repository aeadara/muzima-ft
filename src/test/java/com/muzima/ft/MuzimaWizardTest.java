package com.muzima.ft;

import com.muzima.ft.page_object.Dashboard;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MuzimaWizardTest {
  private Muzima muzima;

  @Before
  public void setUp() throws Exception {
    muzima = new Muzima();
    muzima.install();
  }

  @Test
  public void shouldAllowDataToBeDownloadedWhenRunningWizard() throws Exception {
    Dashboard dashboard =
      muzima
        .start()

        .readTermsAndConditions()
        .agreeToTermsAndConditions()

        .enterUsername()
        .enterPassword()
        .login()

        .waitForCohortsToLoad()
        .selectCDMCohort()
        .downloadSelectedCohorts()

        .waitForFormTemplatesToLoad()
        .scrollDownToRegistrationForm()
        .selectRegistrationForm()
        .downloadSelectedFormTemplates()

        .waitForLocationsToLoad()
        .searchLocation()
        .selectLocation()
        .downloadSelectedLocations()

        .waitForProvidersToLoad()
        .searchProvider()
        .selectProvider()
        .downloadSelectedProviders()

        .waitForConceptsToLoad()
        .searchConcept()
        .selectConcept()
        .downloadSelectedConcepts()

        .waitForBarcodeScannerToLoad()
        .skipBarcodeScanner()

        .waitForDashboardToLoad();

    assertEquals("1 Synced, 8 Total", dashboard.getCohortSyncStatus());
    assertEquals("5 Synced", dashboard.getFormSyncStatus());
  }

  @After
  public void tearDown() throws Exception {
    muzima.quit();
  }

}
