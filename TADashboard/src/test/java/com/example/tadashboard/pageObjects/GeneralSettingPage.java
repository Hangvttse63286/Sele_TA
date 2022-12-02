package com.example.tadashboard.pageObjects;

import com.example.tadashboard.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class GeneralSettingPage extends BasePage {
    private final By ddlItemType = By.id("cbbEntityType");

    private Select getDdlItemType() {
        return new Select(DriverManager.findElement(ddlItemType));
    }

    private List<WebElement> getDdlItemTypeOptions() {
        return getDdlItemType().getOptions();
    }

    public List<String> getDdlItemTypeOptionsText() {
        return getDdlItemTypeOptions().stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
