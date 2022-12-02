package com.example.tadashboard.pageObjects;

import com.example.tadashboard.common.utilities.DriverManager;
import com.example.tadashboard.dataObjects.Constant;
import com.example.tadashboard.dataObjects.GlobalSettingSubMenu;
import com.example.tadashboard.dataObjects.HeadMenuTab;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class BasePage {
    private final By header = By.id("header");
    private final By mnuMainMenu = By.id("main-menu");
    private final By mnuGlobalSettingMenu = By.xpath("//li[@class='mn-setting']");
    private final By tabOverview = By.xpath("//a[.='Overview']");
    private final By tabExecutionDashboard = By.xpath("//a[.='Execution Dashboard']");
    private final By btnChoosePanel = By.id("btnChoosepanel");
    private final By divChoosePanels = By.cssSelector(".ccpanels");
    private final By btnCreateNewPanel = By.xpath("//div[@class='cpbutton']//span[.='Create new panel']");
    private final String headMenuTabXPath = "//ul[@class='head-menu']//a[contains(text(), '%s')]";
    private final String subMnuAdministerXPath = "//..//a[.='%s']";
    private final String pageXPath = "//a[contains(text(),'%s')]";
    private final String globalSettingMenuTabXPath = "//a[.='%s']";
    private static final String CURRENT_PAGE_TAB = "xpath=//a[@class='active haschild']";
    private static final String DYNAMIC_PAGE_TAB_BY_INDEX = "xpath=//div[@id='main-menu']//li[%s]/a";
    private static final String ALL_PAGE_TABS = "xpath=//div[@id='main-menu']//a/..";

    protected WebElement getHeader() {
        return DriverManager.findElement(header);
    }

    protected WebElement getMnuMainMenu() {
        return DriverManager.findElement(mnuMainMenu);
    }

    protected WebElement getMnuGlobalSettingMenu() {
        return getMnuMainMenu().findElement(mnuGlobalSettingMenu);
    }

    protected WebElement getTabOverview() {
        return getMnuMainMenu().findElement(tabOverview);
    }

    protected WebElement getTabExecutionDashboard() {
        return getMnuMainMenu().findElement(tabExecutionDashboard);
    }

    protected WebElement getHeadMenuTab(HeadMenuTab tab) {
        return getHeader().findElement(By.xpath(String.format(headMenuTabXPath, tab.getTab())));
    }

    protected WebElement getSubMnuAdminister(HeadMenuTab subTab) {
        return getHeadMenuTab(HeadMenuTab.ADMINISTER).findElement(By.xpath(String.format(subMnuAdministerXPath, subTab.getTab())));
    }

    public void clickTabOverview() {
        getTabOverview().click();
    }

    public Boolean isTabOverviewClickable() {
        try {
            clickTabOverview();
            return true;
        } catch (ElementClickInterceptedException e) {
            return false;
        }
    }

    public void clickTabExecutionDashboard() {
        getTabExecutionDashboard().click();
    }

    public Boolean isTabExecutionDashboardClickable() {
        try {
            clickTabExecutionDashboard();
            return true;
        } catch (ElementClickInterceptedException e) {
            return false;
        }
    }

    public Boolean isHeadMenuTabClickable(HeadMenuTab tab) {
        try {
            clickHeadMenuTab(tab);
            return true;
        } catch (ElementClickInterceptedException e) {
            return false;
        }
    }

    public void clickSubMnuAdminister(HeadMenuTab subTab){
        DriverManager.waitVisibility(getHeadMenuTab(HeadMenuTab.ADMINISTER), Constant.LONG_TIMEOUT);
        hoverHeadMenuTab(HeadMenuTab.ADMINISTER);
        getSubMnuAdminister(subTab).click();
    }

    protected WebElement getPageTab(String page) {
        page = page.replaceAll("\\s+", " ");
        return getMnuMainMenu().findElement(By.xpath(String.format(pageXPath, page)));
    }

    protected WebElement getChildPage(String parentPage, String childPage) {
        hoverPageTab(parentPage);
        childPage = childPage.replaceAll("\\s+", " ");
        return getPageTab(parentPage).findElement(By.xpath("//.." + String.format(pageXPath, childPage)));
    }

    protected WebElement getFirstChildPage(String parentPage) {
        hoverPageTab(parentPage);
        return getPageTab(parentPage).findElement(By.xpath("//..//li/a"));
    }

    public Boolean isChildPageAdded(String parentPage, String childPage) {
        try {
            hoverPageTab(parentPage);
            getChildPage(parentPage, childPage);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void hoverPageTab(String page) {
        DriverManager.moveToElement(getPageTab(page));
    }

    public void clickPageTab(String page) {
        getPageTab(page).click();
    }

    public void clickHeadMenuTab(HeadMenuTab tab) {
        hoverHeadMenuTab(tab);
        getHeadMenuTab(tab).click();
    }

    public void hoverHeadMenuTab(HeadMenuTab tab) {
        DriverManager.moveToElement(getHeadMenuTab(tab));
    }

    protected WebElement getGlobalSettingMenuTab(GlobalSettingSubMenu tab) {
        return getMnuGlobalSettingMenu().findElement(By.xpath(String.format(globalSettingMenuTabXPath, tab.getTab())));
    }

    public void clickGlobalSettingMenuTab(GlobalSettingSubMenu tab) {
        DriverManager.waitVisibility(getMnuGlobalSettingMenu(), Constant.LONG_TIMEOUT);
        hoverMnuGlobalSettingMenu();
        getGlobalSettingMenuTab(tab).click();
    }

    public void hoverMnuGlobalSettingMenu() {
        DriverManager.moveToElement(getMnuGlobalSettingMenu());
    }

    public void deletePage(String page) throws InterruptedException {
        Thread.sleep(500);
        clickPageTab(page);
        clickGlobalSettingMenuTab(GlobalSettingSubMenu.DELETE);
        DriverManager.acceptAlert();
    }

    public void deleteChildPage(String parentPage, String childPage) throws InterruptedException {
        Thread.sleep(500);
        getChildPage(parentPage, childPage).click();
        clickGlobalSettingMenuTab(GlobalSettingSubMenu.DELETE);
        DriverManager.acceptAlert();
    }

    public String getNameTabAtCurrentPage() {
        DriverManager.waitVisibility(DriverManager.getByLocator(CURRENT_PAGE_TAB), Constant.LONG_TIMEOUT);
        return DriverManager.getElementText(CURRENT_PAGE_TAB);
    }

    public int getIndexTabByName(String tabName) {
        int locate = 0;
        int totalTab = DriverManager.getElementSize(ALL_PAGE_TABS);
        for (int index = 1; index <= totalTab; index++) {
            String text = DriverManager.getElementText(DYNAMIC_PAGE_TAB_BY_INDEX, String.valueOf(index));
            if (text.equals(tabName)) {
                locate = index;
                break;
            }
        }
        return locate;
    }
}
