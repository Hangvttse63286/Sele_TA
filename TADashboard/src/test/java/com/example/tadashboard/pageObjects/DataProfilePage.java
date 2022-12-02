package com.example.tadashboard.pageObjects;

import com.example.tadashboard.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class DataProfilePage extends BasePage {
    private final By lnkAddNew = By.xpath("//div[@class='panel_tag2']//a[.='Add New']");
    private final By lnkDelete = By.xpath("//div[@class='panel_tag2']//a[.='Delete']");
    private final By lnkCheckAll = By.xpath("//form[@id='form1']//table//a[.='Check All']");
    private final By lnkUnCheckAll = By.xpath("//form[@id='form1']//table//a[.='UnCheck All']");
    private final By lblDataProfiles = By.xpath("//form[@id='form1']//table//td[count(//th[.='Data Profile']/preceding-sibling::th)+1]");

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

    private List<WebElement> getDataProfiles() {
        return DriverManager.findElements(lblDataProfiles);
    }

    public List<String> getDataProfilesText() {
        return getDataProfiles().stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getSortDataProfilesText() {
        List<String> sortList = getDataProfilesText();
        sortList.sort(String.CASE_INSENSITIVE_ORDER);
        return sortList;
    }
}
