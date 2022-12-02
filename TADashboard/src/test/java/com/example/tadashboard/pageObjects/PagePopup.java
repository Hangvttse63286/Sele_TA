package com.example.tadashboard.pageObjects;

import com.example.tadashboard.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PagePopup {
    private final By popupPage = By.id("div_popup");
    private final By txtPageName = By.id("name");
    private final By ddlParentPage = By.id("parent");
    private final By ddlNumOfCol = By.id("columnnumber");
    private final By ddlAfterPage = By.id("afterpage");
    private final By chkPublic = By.id("ispublic");
    private final By btnOk = By.id("OK");
    private final By btnCancel = By.id("Cancel");

    private WebElement getPopupPage() {
        return DriverManager.findElement(popupPage);
    }

    private WebElement getTxtPageName() {
        return getPopupPage().findElement(txtPageName);
    }

    private Select getDdlParentPage() {
        return new Select(getPopupPage().findElement(ddlParentPage));
    }

    private Select getDdlNumOfCol() {
        return new Select(getPopupPage().findElement(ddlNumOfCol));
    }

    private Select getDdlAfterPage() {
        return new Select(getPopupPage().findElement(ddlAfterPage));
    }

    private WebElement getChkPublic() {
        return getPopupPage().findElement(chkPublic);
    }

    private WebElement getBtnOk() {
        return getPopupPage().findElement(btnOk);
    }

    private WebElement getBtnCancel() {
        return getPopupPage().findElement(btnCancel);
    }

    public void addNewPage(String name, String parentPage, int numOfCol, String displayAfterPage, boolean isPublic) throws InterruptedException {
        sendKeyToTxtPageName(name);
        selectForDdlParentPage(parentPage);
        getDdlNumOfCol().selectByVisibleText(String.valueOf(numOfCol));
        selectForDdlAfterPage(displayAfterPage);
        if (getChkPublic().isSelected() != isPublic)
            getChkPublic().click();
        clickBtnOk();
    }

    public void sendKeyToTxtPageName(String name) {
        getTxtPageName().clear();
        getTxtPageName().sendKeys(name);
    }

    public void selectForDdlParentPage(String parentPage) {
        getDdlParentPage().selectByVisibleText(parentPage);
    }

    public void selectForDdlAfterPage(String displayAfterPage) {
        getDdlAfterPage().selectByVisibleText(displayAfterPage);
    }

    public void clickBtnOk() throws InterruptedException {
        getBtnOk().click();
    }

    public void clickBtnCancel() {
        getBtnCancel().click();
    }

    public void waitUntilPopupDisplayed() {
        DriverManager.waitVisibility(getPopupPage(), 3);
    }

    public void waitUntilPopupDisappear() {
        DriverManager.waitInVisibility(getPopupPage(), 3);
    }
}
