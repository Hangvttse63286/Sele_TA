package com.example.tadashboard.testcases;

import com.example.tadashboard.common.constant.AssertMessage;
import com.example.tadashboard.common.utilities.DriverManager;
import com.example.tadashboard.common.utilities.extentreports.ExtentTestManager;
import com.example.tadashboard.common.utilities.listener.ReportListener;
import com.example.tadashboard.dataObjects.ChartType;
import com.example.tadashboard.dataObjects.Constant;
import com.example.tadashboard.dataObjects.HeadMenuTab;
import com.example.tadashboard.dataObjects.Url;
import com.example.tadashboard.pageObjects.DashboardPage;
import com.example.tadashboard.pageObjects.LoginPage;
import com.example.tadashboard.pageObjects.PanelPage;
import com.example.tadashboard.pageObjects.PanelPopup;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(ReportListener.class)
public class DA_PANEL_TC058 extends BaseTest {

    @Test(description = "Verify that 'Category', 'Series' and 'Caption' field are enabled and disabled correctly corresponding to each type of the 'Chart Type'")
    public void DA_PANEL_TC058() throws InterruptedException {
        ExtentTestManager.logMessage("DA_PANEL_TC058: Verify that 'Category', 'Series' and 'Caption' field are enabled and disabled correctly corresponding to each type of the 'Chart Type'");

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
        PanelPopup panelPopup = new PanelPopup();

        ExtentTestManager.logMessage("Create a new panel");
        String panelName = "Logigear";
        panelPopup.sendKeyTxtDisplayName(panelName);
        panelPopup.selectOptDdlChartType(ChartType.PIE);
        panelPopup.selectOtpSeries("name");
        panelPopup.clickBtnOk();
        panelPopup.waitUntilPopupDisappear();

        ExtentTestManager.logMessage("Click Edit link");
        panelPage.clickLnkOfRowPanel(panelName, "Edit");

        ExtentTestManager.logMessage("Change Chart Type for panel");
        panelPopup.selectOptDdlChartType(ChartType.PIE);

        ExtentTestManager.logMessage("Verify that Category and Caption are disabled Series is enabled");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(panelPopup.isDdlCategoryEnabled(), AssertMessage.ELEMENT_STILL_ENABLED.getMsg() + "dropdown category");
        softAssert.assertFalse(panelPopup.isTxtCaptionCategoryEnabled(), AssertMessage.ELEMENT_STILL_ENABLED.getMsg() + "textbox caption category");
        softAssert.assertFalse(panelPopup.isTxtCaptionValueEnabled(), AssertMessage.ELEMENT_STILL_ENABLED.getMsg() + "textbox caption value");
        softAssert.assertTrue(panelPopup.isDdlSeriesEnabled(), AssertMessage.ELEMENT_NOT_ENABLED.getMsg() + "dropdown series");
        softAssert.assertAll(ChartType.PIE.getType());

        ExtentTestManager.logMessage("Change Chart Type for panel");
        panelPopup.selectOptDdlChartType(ChartType.SINGLE_BAR);

        ExtentTestManager.logMessage("Verify that Category is disabled Series and Caption are enabled");
        softAssert.assertFalse(panelPopup.isDdlCategoryEnabled(), AssertMessage.ELEMENT_STILL_ENABLED.getMsg() + "dropdown category");
        softAssert.assertTrue(panelPopup.isTxtCaptionCategoryEnabled(), AssertMessage.ELEMENT_NOT_ENABLED.getMsg() + "textbox caption category");
        softAssert.assertTrue(panelPopup.isTxtCaptionValueEnabled(), AssertMessage.ELEMENT_NOT_ENABLED.getMsg() + "textbox caption value");
        softAssert.assertTrue(panelPopup.isDdlSeriesEnabled(), AssertMessage.ELEMENT_NOT_ENABLED.getMsg() + "dropdown series");
        softAssert.assertAll(ChartType.SINGLE_BAR.getType());

        ExtentTestManager.logMessage("Change Chart Type for panel");
        panelPopup.selectOptDdlChartType(ChartType.STACKED_BAR);

        ExtentTestManager.logMessage("Verify that all of them are enabled");
        softAssert.assertTrue(panelPopup.isDdlCategoryEnabled(), AssertMessage.ELEMENT_NOT_ENABLED.getMsg() + "dropdown category");
        softAssert.assertTrue(panelPopup.isTxtCaptionCategoryEnabled(), AssertMessage.ELEMENT_NOT_ENABLED.getMsg() + "textbox caption category");
        softAssert.assertTrue(panelPopup.isTxtCaptionValueEnabled(), AssertMessage.ELEMENT_NOT_ENABLED.getMsg() + "textbox caption value");
        softAssert.assertTrue(panelPopup.isDdlSeriesEnabled(), AssertMessage.ELEMENT_NOT_ENABLED.getMsg() + "dropdown series");
        softAssert.assertAll(ChartType.STACKED_BAR.getType());

        ExtentTestManager.logMessage("Change Chart Type for panel");
        panelPopup.selectOptDdlChartType(ChartType.GROUP_BAR);

        ExtentTestManager.logMessage("Verify that all of them are enabled");
        softAssert.assertTrue(panelPopup.isDdlCategoryEnabled(), AssertMessage.ELEMENT_NOT_ENABLED.getMsg() + "dropdown category");
        softAssert.assertTrue(panelPopup.isTxtCaptionCategoryEnabled(), AssertMessage.ELEMENT_NOT_ENABLED.getMsg() + "textbox caption category");
        softAssert.assertTrue(panelPopup.isTxtCaptionValueEnabled(), AssertMessage.ELEMENT_NOT_ENABLED.getMsg() + "textbox caption value");
        softAssert.assertTrue(panelPopup.isDdlSeriesEnabled(), AssertMessage.ELEMENT_NOT_ENABLED.getMsg() + "dropdown series");
        softAssert.assertAll(ChartType.GROUP_BAR.getType());

        ExtentTestManager.logMessage("Change Chart Type for panel");
        panelPopup.selectOptDdlChartType(ChartType.LINE);

        ExtentTestManager.logMessage("Verify that all of them are enabled");
        softAssert.assertTrue(panelPopup.isDdlCategoryEnabled(), AssertMessage.ELEMENT_NOT_ENABLED.getMsg() + "dropdown category");
        softAssert.assertTrue(panelPopup.isTxtCaptionCategoryEnabled(), AssertMessage.ELEMENT_NOT_ENABLED.getMsg() + "textbox caption category");
        softAssert.assertTrue(panelPopup.isTxtCaptionValueEnabled(), AssertMessage.ELEMENT_NOT_ENABLED.getMsg() + "textbox caption value");
        softAssert.assertTrue(panelPopup.isDdlSeriesEnabled(), AssertMessage.ELEMENT_NOT_ENABLED.getMsg() + "dropdown series");
        softAssert.assertAll(ChartType.LINE.getType());

        panelPopup.clickBtnCancel();
        panelPage.clickLnkCheckAll();
        panelPage.clickLnkDelete();
        DriverManager.acceptAlert();
    }
}
