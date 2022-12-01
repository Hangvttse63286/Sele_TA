package com.example.tadashboard.pageObjects;

import com.example.tadashboard.common.utilities.DriverManager;
import com.example.tadashboard.dataObjects.ChartType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class PanelPopup extends BasePage {
    private final By popupPanel = By.xpath("//div[contains(@class,'ui-dialog editpanelDlg')]");
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

    public void selectOptDdlChartType(ChartType type) {
        getDdlChartType().selectByValue(type.getType());
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

    public void clickBtnCancel() {
        getBtnCancel().click();
    }

    public static final String DDL_OPTIONS_OF_DATA_PROFILE = "xpath=//td[.='Data Profile']/..//option";
    public static final String DYNAMIC_OPTION_AT_DATA_PROFILE_BY_INDEX = "xpath=//select[@class='panelProfile']/option[%s]";

    public boolean validateSortingDataProfile() {
        int count = DriverManager.getElementSize(DDL_OPTIONS_OF_DATA_PROFILE);
        List<String> list = new ArrayList<String>();
        for (int i = 1; i <= count; i++) {
            String text = DriverManager.getElementText(DYNAMIC_OPTION_AT_DATA_PROFILE_BY_INDEX, String.valueOf(i));
            list.add(text);
        }
        List<String> list2 = list;
        list.sort(String.CASE_INSENSITIVE_ORDER);
        return list2.equals(list);
    }
}
