package com.onpier.wgv.tests;

import com.onpier.wgv.utils.ConfigReader;
import com.onpier.wgv.utils.Constants;
import com.onpier.wgv.utils.DriverManager;
import com.onpier.wgv.utils.ExtentReport;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class BaseTest {

    @BeforeSuite
    protected void loadConfigs() throws IOException {
        ConfigReader.loadProps();
        ExtentReport.initReports();
    }
    @BeforeMethod
    protected void setDriver() throws Exception{
        DriverManager.launchDriver(Constants.CHROME);
        DriverManager.driver.get(ConfigReader.getConfigProps().getProperty("URL"));
        DriverManager.driver.manage().window().maximize();
    }

    @AfterMethod
    protected void tearDown() throws Exception{
        Thread.sleep(5000);
        DriverManager.quitDriver();
    }
}
