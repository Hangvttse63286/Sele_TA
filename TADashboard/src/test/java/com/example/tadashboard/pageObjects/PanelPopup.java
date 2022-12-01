package com.example.tadashboard.pageObjects;

import com.example.tadashboard.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PanelPopup extends BasePage {
    private final By popupPanel = By.xpath("//div[@class='ui-dialog editpanelDlg']");
    private final By txtDisplayName = By.id("txtDisplayName");
    private final By ddlChartType = By.id("cbbChartType");
    private final By ddlCategory = By.id("cbbCategoryField");
    private final By ddlSeries = By.id("cbbSeriesField");
    private final By txtCaptionCategory = By.id("txtCategoryXAxis");
    private final By txtCaptionValue = By.id("txtValueYAxis");
    private final By btnOk = By.id("OK");
    private final By btnCancel = By.id("Cancel");

    private WebElement getPopupPanel() {
        return DriverManager.findElement(popupPanel);
    }

    private WebElement getTxtDisplayName() {
        return getPopupPanel().findElement(txtDisplayName);
    }

    private Select getDdlChartType() {
        return new Select(getPopupPanel().findElement(ddlChartType));
    }

    private Select getDdlCategory() {
        return new Select(getPopupPanel().findElement(ddlCategory));
    }

    private Select getDdlSeries() {
        return new Select(getPopupPanel().findElement(ddlSeries));
    }

    private WebElement getTxtCaptionCategory() {
        return getPopupPanel().findElement(txtCaptionCategory);
    }

    private WebElement getTxtCaptionValue() {
        return getPopupPanel().findElement(txtCaptionValue);
    }

    private WebElement getBtnOk() {
        return getPopupPanel().findElement(btnOk);
    }

    private WebElement getBtnCancel() {
        return getPopupPanel().findElement(btnCancel);
    }

    public void sendKeyTxtDisplayName(String name) {
        getTxtDisplayName().sendKeys(name);
    }

    public void selectOptDdlChartType(String option) {
        getDdlChartType().selectByValue(option);
    }

    public void selectOtpSeries(String option) {
        getDdlSeries().selectByValue(option);
    }

    public Boolean isDdlCategoryEnabled() {
        return getDdlCategory().getWrappedElement().isEnabled();
    }

    public Boolean isDdlSeriesEnabled() {
        return getDdlSeries().getWrappedElement().isEnabled();
    }

    public Boolean isTxtCaptionCategoryEnabled() {
        return getTxtCaptionCategory().isEnabled();
    }

    public Boolean isTxtCaptionValueEnabled() {
        return getTxtCaptionValue().isEnabled();
    }

    public void clickBtnOk() {
        getBtnOk().click();
    }
}
