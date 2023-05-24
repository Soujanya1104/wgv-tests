package com.onpier.wgv.pages;

import org.openqa.selenium.By;

public class LandingPage extends BasePage {

private final By vehicleClassOption=By.xpath("//*[contains(text(),'DynamicText')]");
private final By premiumModelApplyButton=By.xpath("//*[text()='DynamicText']/ancestor::*[@class='mat-mdc-card-content']//button");

public LandingPage selectVehicleClassOption(String vehicleClass){
    click(buildDynamicLocator(vehicleClassOption, vehicleClass), "Select Vehicle Class Option");
    return this;
}

public VehicleRegistrationPage selectPremiumModelOption(String premiumModel){
    click(buildDynamicLocator(premiumModelApplyButton, premiumModel), "Select Premium model Option");
    return new VehicleRegistrationPage();
}
}
