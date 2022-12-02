package com.example.tadashboard.testcases;

import com.example.tadashboard.common.utilities.DriverManager;
import com.example.tadashboard.common.utilities.extentreports.ExtentTestManager;
import com.example.tadashboard.common.utilities.listener.ReportListener;
import com.example.tadashboard.dataObjects.Constant;
import com.example.tadashboard.dataObjects.HeadMenuTab;
import com.example.tadashboard.dataObjects.ItemType;
import com.example.tadashboard.dataObjects.Url;
import com.example.tadashboard.pageObjects.DashboardPage;
import com.example.tadashboard.pageObjects.DataProfilePage;
import com.example.tadashboard.pageObjects.GeneralSettingPage;
import com.example.tadashboard.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ReportListener.class)
public class DA_DP_TC072 extends BaseTest {

    @Test(description = "Verify that all data profile types are listed under 'Item Type' dropped down menu")
    public void DA_DP_TC072() throws InterruptedException {
        ExtentTestManager.logMessage("DA_DP_TC072: Verify that all data profile types are listed under 'Item Type' dropped down menu");

        ExtentTestManager.logMessage("Navigate to Dashboard login page");
        DriverManager.open(Url.TA_LOGIN);
        LoginPage loginPage = new LoginPage();

        ExtentTestManager.logMessage("Select a specific repository");
        loginPage.selectRepository("SampleRepository");

        ExtentTestManager.logMessage("Enter valid Username and Password");
        ExtentTestManager.logMessage("Click Login");
        loginPage.login(Constant.VALID_TEST_USERNAME, Constant.VALID_TEST_PASSWORD);
        DashboardPage dashboardPage = new DashboardPage();

        ExtentTestManager.logMessage("Click Administer->Data Profiles");
        dashboardPage.clickSubMnuAdminister(HeadMenuTab.ADMINISTER_DATA_PROFILES);
        DataProfilePage dataProfilePage = new DataProfilePage();

        ExtentTestManager.logMessage("Click Add New link");
        dataProfilePage.clickLnkAddNew();
        GeneralSettingPage generalSettingPage = new GeneralSettingPage();

        ExtentTestManager.logMessage("Check all data profile types are listed under 'Item Type' dropped down menu in create profile page");
        Assert.assertEquals(generalSettingPage.getDdlItemTypeOptionsText(), ItemType.getItemTypes());
    }
}
