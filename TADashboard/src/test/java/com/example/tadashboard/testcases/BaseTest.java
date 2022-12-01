package com.example.tadashboard.testcases;

import com.example.tadashboard.common.utilities.DriverManager;
import com.example.tadashboard.common.utilities.Log;
import com.example.tadashboard.common.utilities.helpers.ConfigFileReader;
import com.example.tadashboard.dataObjects.Url;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.Arrays;

public class BaseTest {

    public void initializeTestBaseSetup() {
        try {
            ConfigFileReader.setConfigFileReader();
            DriverManager.setDriver();
            DriverManager.maximizeWindow();
            DriverManager.pageLoadTimeout();
            DriverManager.implicitlyWait();
        } catch (Exception e) {
            Log.error("Error..." + Arrays.toString(e.getStackTrace()));
        }
    }

    @BeforeMethod
    public void setUp() {
        initializeTestBaseSetup();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.clearAllCookies();
        try {
            Thread.sleep(2000);
            DriverManager.quit();
        } catch (Exception e) {
            Log.error("Error..." + Arrays.toString(e.getStackTrace()));
        }
    }
}
