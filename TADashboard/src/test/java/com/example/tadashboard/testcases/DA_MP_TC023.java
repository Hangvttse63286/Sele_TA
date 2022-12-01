package com.example.tadashboard.testcases;

import com.example.tadashboard.common.utilities.DriverManager;
import com.example.tadashboard.common.utilities.extentreports.ExtentTestManager;
import com.example.tadashboard.common.utilities.listener.ReportListener;
import com.example.tadashboard.dataObjects.Constant;
import com.example.tadashboard.dataObjects.GlobalSettingSubMenu;
import com.example.tadashboard.dataObjects.Url;
import com.example.tadashboard.pageObjects.DashboardPage;
import com.example.tadashboard.pageObjects.LoginPage;
import com.example.tadashboard.pageObjects.PagePopup;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ReportListener.class)
public class DA_MP_TC023 extends BaseTest {
    @Test(description = "Verify that user is able to edit the parent page of the sibbling page successfully")
    public void DA_MP_TC023() throws InterruptedException {
        ExtentTestManager.logMessage("DA_MP_TC023: Verify that user is able to edit the parent page of the sibbling page successfully");
        LoginPage loginPage = new LoginPage();
        DashboardPage dashboardPage = new DashboardPage();
        PagePopup pagePopup = new PagePopup();

        ExtentTestManager.logMessage("Navigate to Dashboard login page");
        DriverManager.open(Url.TA_LOGIN);
        ExtentTestManager.logMessage("Log in specific repository with valid account");
        loginPage.login(Constant.VALID_TEST_USERNAME, Constant.VALID_TEST_PASSWORD);

        //add page 1
        ExtentTestManager.logMessage("Go to Global Setting -> Add page");
        dashboardPage.clickGlobalSettingMenuTab(GlobalSettingSubMenu.ADD_PAGE);
        ExtentTestManager.logMessage("Enter info into all required fields on New Page dialog");
        pagePopup.sendKeyToTxtPageName(Constant.FIRST_PAGE);
        pagePopup.selectForDdlAfterPage("Overview");
        pagePopup.clickBtnOk();

        //add child page 1
        ExtentTestManager.logMessage("Go to Global Setting -> Add page");
        dashboardPage.clickGlobalSettingMenuTab(GlobalSettingSubMenu.ADD_PAGE);
        ExtentTestManager.logMessage("Enter info into all required fields on New Page dialog");
        pagePopup.sendKeyToTxtPageName(Constant.SECOND_PAGE);
        ExtentTestManager.logMessage("Click on Parent Page dropdown list");
        ExtentTestManager.logMessage("Select parent page");
        pagePopup.selectForDdlParentPage(Constant.FIRST_PAGE);
        ExtentTestManager.logMessage("Click OK button");
        pagePopup.clickBtnOk();

        ExtentTestManager.logMessage("Go to the first created page");
        dashboardPage.clickPageTab("Page 1");
        ExtentTestManager.logMessage("Click Edit link");
        dashboardPage.clickGlobalSettingMenuTab(GlobalSettingSubMenu.EDIT);
        ExtentTestManager.logMessage("Enter another name into Page Name field");
        pagePopup.sendKeyToTxtPageName(Constant.THIRD_PAGE);
        ExtentTestManager.logMessage("Click Ok button on Edit Page dialog");
        pagePopup.clickBtnOk();

        ExtentTestManager.logMessage("Observe the current page");
        Assert.assertEquals(dashboardPage.getNameTabAtCurrentPage(), Constant.THIRD_PAGE);

        //Post-Condition
        ExtentTestManager.logMessage("Delete newly added main child page and its parent page");
        dashboardPage.deleteChildPage("Page 3", "Page 2");
        dashboardPage.deletePage("Page 3");
    }
}
