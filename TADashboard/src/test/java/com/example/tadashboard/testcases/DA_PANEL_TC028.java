package com.example.tadashboard.testcases;

import com.example.tadashboard.common.constant.AssertMessage;
import com.example.tadashboard.common.utilities.DriverManager;
import com.example.tadashboard.common.utilities.extentreports.ExtentTestManager;
import com.example.tadashboard.common.utilities.listener.ReportListener;
import com.example.tadashboard.dataObjects.Constant;
import com.example.tadashboard.dataObjects.GlobalSettingSubMenu;
import com.example.tadashboard.dataObjects.HeadMenuTab;
import com.example.tadashboard.dataObjects.Url;
import com.example.tadashboard.pageObjects.DashboardPage;
import com.example.tadashboard.pageObjects.LoginPage;
import com.example.tadashboard.pageObjects.PanelPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(ReportListener.class)
public class DA_PANEL_TC028 extends BaseTest{

    @Test(description = "Verify that when 'Add New Panel' form is on focused all other control/form is disabled or locked.")
    public void DA_PANEL_TC028_AddAdditionalSiblingPageToParentPage() throws InterruptedException {
        ExtentTestManager.logMessage("DA_PANEL_TC028: Verify that when 'Add New Panel' form is on focused all other control/form is disabled or locked.");

        ExtentTestManager.logMessage("Navigate to Dashboard login page");
        DriverManager.open(Url.TA_LOGIN);
        LoginPage loginPage = new LoginPage();

        ExtentTestManager.logMessage("Log in specific repository with valid account");
        loginPage.login(Constant.VALID_TEST_USERNAME, Constant.VALID_TEST_PASSWORD);
        DashboardPage dashboardPage = new DashboardPage();

        ExtentTestManager.logMessage("Click Administer link");
        ExtentTestManager.logMessage("Click Panel link");
        dashboardPage.clickSubMnuAdminister(HeadMenuTab.ADMINISTER_PANELS);
        PanelPage panelPage = new PanelPage();

        ExtentTestManager.logMessage("Click Add New link");
        panelPage.clickLnkAddNew();

        ExtentTestManager.logMessage("Try to click other controls when Add New Panel dialog is opening");
        ExtentTestManager.logMessage("Verify that all control/form are disabled or locked when Add New Panel dialog is opening");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(panelPage.isTabOverviewClickable(), AssertMessage.ELEMENT_STILL_CLICKABLE.getMsg() + "Overview tab");
        softAssert.assertFalse(panelPage.isTabExecutionDashboardClickable(), AssertMessage.ELEMENT_STILL_CLICKABLE.getMsg() + "Execution Dashboard tab");
        softAssert.assertAll();
    }
}
