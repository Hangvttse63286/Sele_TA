package com.example.tadashboard.testcases;

import com.example.tadashboard.common.utilities.DriverManager;
import com.example.tadashboard.common.utilities.extentreports.ExtentTestManager;
import com.example.tadashboard.common.utilities.listener.ReportListener;
import com.example.tadashboard.dataObjects.Constant;
import com.example.tadashboard.dataObjects.HeadMenuTab;
import com.example.tadashboard.dataObjects.Url;
import com.example.tadashboard.pageObjects.DashboardPage;
import com.example.tadashboard.pageObjects.LoginPage;
import com.example.tadashboard.pageObjects.PanelPage;
import com.example.tadashboard.pageObjects.PanelPopup;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ReportListener.class)
public class DA_PANEL_TC033 extends BaseTest {
    @Test(description = "Verify that 'Data Profile' listing of 'Add New Panel' and 'Edit Panel' control/form are in alphabetical order")
    public void DA_PANEL_TC033() throws InterruptedException {
        ExtentTestManager.logMessage("DA_MP_TC033: Verify that 'Data Profile' listing of 'Add New Panel' and 'Edit Panel' control/form are in alphabetical order");
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        PanelPopup panelPopup = new PanelPopup();
        PanelPage panelPage = new PanelPage();

        ExtentTestManager.logMessage("Navigate to Dashboard login page");
        DriverManager.open(Url.TA_LOGIN);
        ExtentTestManager.logMessage("Log in specific repository with valid account");
        loginPage.login(Constant.VALID_TEST_USERNAME, Constant.VALID_TEST_PASSWORD);

        ExtentTestManager.logMessage("Click on Administer/Panels link");
        dashboardPage.clickSubMnuAdminister(HeadMenuTab.ADMINISTER_PANELS);
        ExtentTestManager.logMessage("Click on Add New link");
        panelPage.clickLnkAddNew();
        ExtentTestManager.logMessage("Verify that Data Profile list is in alphabetical order");
        Assert.assertTrue(panelPopup.validateSortingDataProfile());
        ExtentTestManager.logMessage("Enter a display name to display name field");
        panelPopup.sendKeyTxtDisplayName(Constant.DISPLAY_NAME);
        panelPopup.selectOtpSeries("name");
        ExtentTestManager.logMessage("Click on OK button");
        panelPopup.clickBtnOk();

        ExtentTestManager.logMessage("Click on Edit link");
        panelPage.clickEditByName(Constant.DISPLAY_NAME, "Edit");
        ExtentTestManager.logMessage("Verify that Data Profile list is in alphabetical order");
        Assert.assertTrue(panelPopup.validateSortingDataProfile());

        panelPopup.clickBtnCancel();
        panelPage.clickLnkCheckAll();
        panelPage.clickLnkDelete();
        DriverManager.acceptAlert();
    }
}