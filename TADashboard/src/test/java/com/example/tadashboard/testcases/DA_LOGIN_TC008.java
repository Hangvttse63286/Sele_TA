package com.example.tadashboard.testcases;

import com.example.tadashboard.common.constant.AssertMessage;
import com.example.tadashboard.common.utilities.DriverManager;
import com.example.tadashboard.common.utilities.extentreports.ExtentTestManager;
import com.example.tadashboard.common.utilities.listener.ReportListener;
import com.example.tadashboard.dataObjects.Constant;
import com.example.tadashboard.dataObjects.Message;
import com.example.tadashboard.dataObjects.PageTitle;
import com.example.tadashboard.dataObjects.Url;
import com.example.tadashboard.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ReportListener.class)
public class DA_LOGIN_TC008 extends BaseTest{

    @Test(description = "Verify that password with special characters is working correctly")
    public void DA_LOGIN_TC008_SpecialCharsPassword() throws InterruptedException {
        ExtentTestManager.logMessage("DA_LOGIN_TC008: Verify that password with special characters is working correctly");

        ExtentTestManager.logMessage("Navigate to Dashboard login page");
        DriverManager.open(Url.TA_LOGIN);
        LoginPage loginPage = new LoginPage();

        ExtentTestManager.logMessage("Login with account that has special characters password");
        loginPage.login(Constant.VALID_USERNAME, Constant.SPECIAL_CHARS_PASSWORD);

        ExtentTestManager.logMessage("Verify that Main page is displayed");
        Assert.assertEquals(DriverManager.getPageTitle(), PageTitle.TA_EXECUTION_DASHBOARD.getTitle(), AssertMessage.PAGE_NOT_DISPLAYED.getMsg() + "Dashboard main page");
    }
}
