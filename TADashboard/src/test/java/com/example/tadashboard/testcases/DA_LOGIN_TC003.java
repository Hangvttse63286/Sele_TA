package com.example.tadashboard.testcases;

import com.example.tadashboard.common.constant.AssertMessage;
import com.example.tadashboard.common.utilities.DriverManager;
import com.example.tadashboard.common.utilities.extentreports.ExtentTestManager;
import com.example.tadashboard.common.utilities.listener.ReportListener;
import com.example.tadashboard.dataObjects.Constant;
import com.example.tadashboard.dataObjects.Message;
import com.example.tadashboard.dataObjects.Url;
import com.example.tadashboard.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ReportListener.class)
public class DA_LOGIN_TC003 extends BaseTest {

    @Test(description = "Verify that user fails to log in specific repository successfully via Dashboard login page with correct username and incorrect password")
    public void DA_LOGIN_TC003() throws InterruptedException {
        ExtentTestManager.logMessage("DA_LOGIN_TC003: Verify that user fails to log in specific repository successfully via Dashboard login page with correct username and incorrect password");

        ExtentTestManager.logMessage("Navigate to Dashboard login page");
        DriverManager.open(Url.TA_LOGIN);
        LoginPage loginPage = new LoginPage();

        ExtentTestManager.logMessage("Enter valid username and invalid password");
        ExtentTestManager.logMessage("Click on 'Login' button");
        loginPage.login(Constant.ADMIN_USERNAME, Constant.INVALID_PASSWORD);

        ExtentTestManager.logMessage("Verify that Dashboard Error message 'Username or password is invalid' appears");
        Assert.assertTrue(DriverManager.isAlertDisplayed(3), AssertMessage.ELEMENT_NOT_DISPLAYED + "Dashboard Error message");
        Assert.assertEquals(DriverManager.getAlertMsg(), Message.LOGIN_INVALID_USER.getMsg(), AssertMessage.VALUE_MISMATCH_WITH_EXPECTED + "Dashboard Error message");
        DriverManager.acceptAlert();
    }
}
