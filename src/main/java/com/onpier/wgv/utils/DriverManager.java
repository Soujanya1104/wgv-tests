package com.onpier.wgv.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    public static WebDriver driver;

    public static void launchDriver(String browser) throws MalformedURLException {
        String HUB="https://localhost:4444";
        boolean isRemote= Boolean.TRUE.equals(System.getProperty("isRemote"));
        ChromeOptions options=new ChromeOptions();
        switch(browser){
            case(Constants.CHROME):
                if(isRemote)
                    driver=new RemoteWebDriver(new URL(HUB), options);
                else
                    driver=new ChromeDriver();
                break;
            case(Constants.FIREFOX):
                if(isRemote)
                    driver=new RemoteWebDriver(new URL(HUB), options);
                else
                    driver=new FirefoxDriver();
        }
    }

    public static void quitDriver(){
        driver.quit();
    }
}
