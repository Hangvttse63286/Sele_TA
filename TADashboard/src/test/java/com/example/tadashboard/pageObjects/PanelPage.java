package com.example.tadashboard.pageObjects;

import com.example.tadashboard.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.example.tadashboard.common.utilities.DriverManager.getByLocator;
import static com.example.tadashboard.common.utilities.DriverManager.getDynamicXpath;

public class PanelPage extends BasePage {
    private final By lnkAddNew = By.xpath("//div[@class='panel_tag2']//a[.='Add New']");
    private final By lnkDelete = By.xpath("//div[@class='panel_tag2']//a[.='Delete']");
    private final By lnkCheckAll = By.xpath("//table//a[.='Check All']");
    private final By lnkUnCheckAll = By.xpath("//table//a[.='UnCheck All']");
    private final String rowPanelXPath = "//table//a[.='%s']//ancestor::tr";
    private final String DYNAMIC_ACTION_FOR_PANEL_NAME = "xpath=//a[.='%s']/../..//a[.='%s']";

    private WebElement getLnkAddNew() {
        return DriverManager.findElement(lnkAddNew);
    }

    private WebElement getLnkDelete() {
        return DriverManager.findElement(lnkDelete);
    }

    private WebElement getLnkCheckAll() {
        return DriverManager.findElement(lnkCheckAll);
    }

    private WebElement getLnkUnCheckAll() {
        return DriverManager.findElement(lnkUnCheckAll);
    }

    private WebElement getRowPanel(String panelName) {
        return DriverManager.findElement(By.xpath(String.format(rowPanelXPath, panelName)));
    }

    private WebElement getLnkOfRowPanel(String panelName, String lnk) {
        return getRowPanel(panelName).findElement(By.xpath(String.format("//a[.='%s']", lnk)));
    }

    public void clickLnkOfRowPanel(String panelName, String lnk) {
        getLnkOfRowPanel(panelName, lnk).click();
    }

    public void clickLnkAddNew() {
        getLnkAddNew().click();
    }

    public void clickLnkDelete() {
        getLnkDelete().click();
    }

    public void clickLnkCheckAll() {
        getLnkCheckAll().click();
    }

    public void clickLnkUnCheckAll() {
        getLnkUnCheckAll().click();
    }

    public void clickEditByName(String namePanel, String action) {
        DriverManager.findElement(getByLocator(getDynamicXpath(DYNAMIC_ACTION_FOR_PANEL_NAME, namePanel, action))).click();
    }
}
