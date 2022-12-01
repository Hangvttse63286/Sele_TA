package com.example.tadashboard.testcases;

import com.example.tadashboard.common.constant.AssertMessage;
import com.example.tadashboard.common.utilities.DriverManager;
import com.example.tadashboard.common.utilities.extentreports.ExtentTestManager;
import com.example.tadashboard.common.utilities.listener.ReportListener;
import com.example.tadashboard.dataObjects.Constant;
import com.example.tadashboard.dataObjects.GlobalSettingSubMenu;
import com.example.tadashboard.dataObjects.Url;
import com.example.tadashboard.pageObjects.LoginPage;
import com.example.tadashboard.pageObjects.DashboardPage;
import com.example.tadashboard.pageObjects.PagePopup;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ReportListener.class)
public class DA_MP_TC018 extends BaseTest{

    @Test(description = "Verify that user is able to add additional sibling pages to the parent page successfully")
    public void DA_MP_TC018_AddAdditionalSiblingPageToParentPage() throws InterruptedException {
        ExtentTestManager.logMessage("DA_MP_TC018: Verify that user is able to add additional sibling pages to the parent page successfully");

        ExtentTestManager.logMessage("Navigate to Dashboard login page");
        DriverManager.open(Url.TA_LOGIN);
        LoginPage loginPage = new LoginPage();

        ExtentTestManager.logMessage("Log in specific repository with valid account");
        loginPage.login(Constant.ADMIN_USERNAME, Constant.ADMIN_PASSWORD);
        DashboardPage dashboardPage = new DashboardPage();

        //add parent page
        ExtentTestManager.logMessage("Go to Global Setting -> Add page");
        dashboardPage.clickGlobalSettingMenuTab(GlobalSettingSubMenu.ADD_PAGE);
        PagePopup pagePopup = new PagePopup();
        ExtentTestManager.logMessage("Enter Page Name");
        pagePopup.sendKeyToTxtPageName(Constant.PARENT_PAGE);
        ExtentTestManager.logMessage("Click OK button");
        pagePopup.clickBtnOk();

        //add child page 1
        ExtentTestManager.logMessage("Go to Global Setting -> Add page");
        dashboardPage.clickGlobalSettingMenuTab(GlobalSettingSubMenu.ADD_PAGE);
        ExtentTestManager.logMessage("Enter Page Name");
        pagePopup.sendKeyToTxtPageName(Constant.CHILD_PAGE_1);
        ExtentTestManager.logMessage("Click on Parent Page dropdown list");
        ExtentTestManager.logMessage("Select a parent page");
        pagePopup.selectForDdlParentPage(Constant.PARENT_PAGE);
        ExtentTestManager.logMessage("Click OK button");
        pagePopup.clickBtnOk();

        //add child page 2
        ExtentTestManager.logMessage("Go to Global Setting -> Add page");
        dashboardPage.clickGlobalSettingMenuTab(GlobalSettingSubMenu.ADD_PAGE);
        ExtentTestManager.logMessage("Enter Page Name");
        pagePopup.sendKeyToTxtPageName(Constant.CHILD_PAGE_2);
        ExtentTestManager.logMessage("Click on Parent Page dropdown list");
        ExtentTestManager.logMessage("Select a parent page");
        pagePopup.selectForDdlParentPage(Constant.PARENT_PAGE);
        ExtentTestManager.logMessage("Click OK button");
        pagePopup.clickBtnOk();

        ExtentTestManager.logMessage("Check 'Test Child 2' is added successfully");
        Assert.assertTrue(dashboardPage.isChildPageAdded(Constant.PARENT_PAGE, Constant.CHILD_PAGE_2), AssertMessage.ELEMENT_NOT_DISPLAYED.getMsg() + "Page "+ Constant.CHILD_PAGE_2);

        dashboardPage.deleteChildPage(Constant.PARENT_PAGE, Constant.CHILD_PAGE_2);
        dashboardPage.deleteChildPage(Constant.PARENT_PAGE, Constant.CHILD_PAGE_1);
        dashboardPage.deletePage(Constant.PARENT_PAGE);
    }
}
