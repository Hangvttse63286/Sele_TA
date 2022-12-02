package com.example.tadashboard.testcases;

import com.example.tadashboard.common.utilities.DriverManager;
import com.example.tadashboard.common.utilities.extentreports.ExtentTestManager;
import com.example.tadashboard.common.utilities.listener.ReportListener;
import com.example.tadashboard.dataObjects.Constant;
import com.example.tadashboard.dataObjects.HeadMenuTab;
import com.example.tadashboard.dataObjects.Url;
import com.example.tadashboard.pageObjects.DashboardPage;
import com.example.tadashboard.pageObjects.DataProfilePage;
import com.example.tadashboard.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ReportListener.class)
public class DA_DP_TC067 extends BaseTest {

    @Test(description = "Verify that Data Profiles are listed alphabetically")
    public void DA_DP_TC067() throws InterruptedException {
        ExtentTestManager.logMessage("DA_MP_TC013: Verify that Data Profiles are listed alphabetically");
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();

        ExtentTestManager.logMessage("Navigate to Dashboard login page");
        DriverManager.open(Url.TA_LOGIN);
        ExtentTestManager.logMessage("Select a specific repository ");
        loginPage.selectRepository(Constant.REPOSITORY_NAME);
        ExtentTestManager.logMessage("Enter valid Username and Password");
        ExtentTestManager.logMessage("Click Login");
        loginPage.login(Constant.VALID_TEST_USERNAME, Constant.VALID_TEST_PASSWORD);

        ExtentTestManager.logMessage("Click Administer->Data Profiles");
        dashboardPage.clickSubMnuAdminister(HeadMenuTab.ADMINISTER_DATA_PROFILES);
        DataProfilePage dataProfilePage = new DataProfilePage();

        ExtentTestManager.logMessage("Check Data Profiles are listed alphabetically");
        Assert.assertEquals(dataProfilePage.getDataProfilesText(), dataProfilePage.getSortDataProfilesText());
    }
}
