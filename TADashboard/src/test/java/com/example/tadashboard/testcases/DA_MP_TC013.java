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
public class DA_MP_TC013 extends BaseTest {
    @Test(description = "Verify that the newly added main parent page is positioned at the location specified as set with 'Displayed After' field of 'New Page' form")
    public void DA_MP_TC013() throws InterruptedException {
        ExtentTestManager.logMessage("DA_MP_TC013: Verify that user is able to add additional sibling pages to the parent page successfully");
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
        ExtentTestManager.logMessage("Enter Page Name");
        pagePopup.sendKeyToTxtPageName(Constant.FIRST_PAGE);
        ExtentTestManager.logMessage("Click OK button");
        pagePopup.clickBtnOk();
        pagePopup.waitUntilPopupDisappear();

        //add page 2
        ExtentTestManager.logMessage("Go to Global Setting -> Add page");
        dashboardPage.clickGlobalSettingMenuTab(GlobalSettingSubMenu.ADD_PAGE);
        ExtentTestManager.logMessage("Enter Page Name");
        pagePopup.sendKeyToTxtPageName(Constant.SECOND_PAGE);
        ExtentTestManager.logMessage("Click on Parent Page dropdown list");
        ExtentTestManager.logMessage("Select specific page");
        pagePopup.selectForDdlAfterPage(Constant.FIRST_PAGE);
        ExtentTestManager.logMessage("Click OK button");
        pagePopup.clickBtnOk();
        pagePopup.waitUntilPopupDisappear();

        ExtentTestManager.logMessage("Verify 'Part 2' page is positioned besides the 'Part 1' page");
        Assert.assertTrue(dashboardPage.getIndexTabByName(Constant.SECOND_PAGE) == (dashboardPage.getIndexTabByName(Constant.FIRST_PAGE) + 1));

        //Post-Condition
        ExtentTestManager.logMessage("Delete newly added main child page and its parent page");
        dashboardPage.deletePage("Page 1");
        dashboardPage.deletePage("Page 2");
    }
}
