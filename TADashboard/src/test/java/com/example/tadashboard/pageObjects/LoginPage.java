package com.example.tadashboard.pageObjects;

import com.example.tadashboard.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final By ddlRepository = By.id("repository");
    private final By txtUsername = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.cssSelector(".btn-login");

    private WebElement getDdlRepository() {
        return DriverManager.findElement(ddlRepository);
    }

    private WebElement getTxtUsername() {
        return DriverManager.findElement(txtUsername);
    }

    private WebElement getTxtPassword() {
        return DriverManager.findElement(txtPassword);
    }

    private WebElement getBtnLogin() {
        return DriverManager.findElement(btnLogin);
    }

    public void login(String username, String password) throws InterruptedException {
        DriverManager.scrollToView(getBtnLogin());
        getTxtUsername().sendKeys(username);
        getTxtPassword().sendKeys(password);
        getBtnLogin().click();
        Thread.sleep(500);
    }
}
