package com.example.tadashboard.pageObjects;

import com.example.tadashboard.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PanelPage extends BasePage {
    private final By lnkAddNew = By.xpath("//a[.='Add New']");
    private final String rowPanelXPath = "//table//a[.='%s']/ancestor::tr";

    private WebElement getLnkAddNew() {
        return DriverManager.findElement(lnkAddNew);
    }

    private WebElement getRowPanel(String panelName) {
        return DriverManager.findElement(By.xpath(String.format(rowPanelXPath, panelName)));
    }

    private WebElement getLnkOfRowPanel(String panelName, String lnk) {
        return getRowPanel(panelName).findElement(By.xpath(String.format("//a[.='%s'", lnk)));
    }

    public void clickLnkOfRowPanel(String panelName, String lnk) {
        getLnkOfRowPanel(panelName, lnk).click();
    }

    public void clickLnkAddNew() {
        getLnkAddNew().click();
    }
}
