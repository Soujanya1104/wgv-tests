package com.onpier.wgv.pages;

import org.openqa.selenium.By;

public class VehicleRegistrationPage extends BasePage {
    private final By vehicleRegistrationCardFrontFileUpload=By.xpath("//*[@filename='teil1Page1']//input[@name='file-upload']");
    private final By vehicleRegistrationCardBackFileUpload=By.xpath("//*[@filename='teil1Page2']//input[@name='file-upload']");
    private final By proceedButton=By.xpath("//div[contains(text(),'DynamicText')]/ancestor::button[1]");

    public VehicleRegistrationPage uploadVehicleRegCardFrontUpload(String fileName){
        sendKeys(vehicleRegistrationCardFrontFileUpload,fileName);
        return this;
    }
    public VehicleRegistrationPage uploadVehicleRegCardBackUpload(String fileName){
        sendKeys(vehicleRegistrationCardBackFileUpload,fileName);
        return this;
    }
    public PersonalInformationPage submitVehicleRegPage(String dynamicText){
        click(buildDynamicLocator(proceedButton,dynamicText),"Vehicle Registration - Proceed button click");
        return new PersonalInformationPage();
    }

}
