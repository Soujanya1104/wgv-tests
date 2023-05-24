package com.onpier.wgv.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ExtentReport {

        private static ExtentReports extent;
        public static ExtentTest extentTest;

        public static void initReports(){
            extent=new ExtentReports();
            ExtentSparkReporter spark=new ExtentSparkReporter("index.html");
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setReportName("Onpier feature test");
        }
        public static void flushReport() throws IOException {
            extent.flush();
            Desktop.getDesktop().browse(new File("index.html").toURI());
        }
        public static void createTest(String testCaseName){
            extentTest=extent.createTest(testCaseName);
        }
        public static ExtentTest getExtentTest(){
            return extentTest;
        }

}
