package com.onpier.wgv.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.List;

public class PersonalInformationPage extends BasePage{

    private final By pageHeading=By.xpath("//app-step2/h2");
    private final By pageSubHeading=By.xpath("//app-step2/p");
    private final By uploadVehicleRegistrationUserJourney=By.xpath("//mat-step-header[1]//mat-icon");
    private final By uploadPersonalInfoUserJourney=By.xpath("//mat-step-header[2]");
    private final By userTypePrivateRadioField=By.xpath("//mat-radio-button//input[@id='mat-radio-2-input']");
    private final By userTypeCompanyRadioField=By.xpath("//mat-radio-button//input[@id='mat-radio-3-input']");
    private final By userTypeCompanyRadio=By.xpath("//*[@id='mat-radio-3']");
    private final By userTypePrivateLabel=By.xpath("//mat-radio-button[@id='mat-radio-2']//label");
    private final By userTypeCompanyLabel=By.xpath("//mat-radio-button[@id='mat-radio-3']//label");
    private final By proceedButton=By.xpath("//app-step2//div[contains(text(),'Weiter')]/ancestor::button[1]");
    private final By backButton=By.xpath("//app-step2//button[contains(text(),'Zurück')]");
    private final By fieldNameLabel=By.xpath("//label[text()='DynamicText']/ancestor::onpier-input//input");
    private final By fieldNameTextField=By.xpath("//label[text()='DynamicText']/ancestor::onpier-input//input");
    private final By fieldNameErrorLabel=By.xpath("//label[text()='DynamicText']/ancestor::onpier-input//p");
    private final By genderListFieldLabel=By.xpath("//label[text()='Anrede']/ancestor::onpier-input//mat-select/parent::div/label");
    private final By genderListField=By.xpath("//label[text()='Anrede']/ancestor::onpier-input//mat-select");
    private final By genderListOptions=By.xpath("//mat-option/span");
    private final By genderSelect=By.xpath("//mat-option/span[text()='Frau']");
    private final By infoTextIcon=By.xpath("//label[text()='DynamicText']/ancestor::onpier-input/following-sibling::mat-icon");
    private final By infoTextContaier=By.xpath("//div[@class='contact-container']");
    private final By infoTextContainerTitle=By.xpath("//div[@class='contact-container']//p[contains(@class,'title')]");
    private final By infoTextContainerDescription=By.xpath("//div[@class='contact-container']//p[contains(@class,'description')]/p");
    private final By infoTextContainerDescription2=By.xpath("//div[@class='contact-container']//p[contains(@class,'description')][2]");
    private final By infoTextContainerClose= By.xpath("//mat-icon[text()='close']");
    public void sendTextToFormField(String field, Keys data){
        sendKeys(buildDynamicLocator(fieldNameTextField,field),data);
    }
    public String getFormFieldText(String field){
        return getAttribute(buildDynamicLocator(fieldNameTextField,field),"value");
    }
    public void sendTextToFormField(String field, String data){
        sendKeys(buildDynamicLocator(fieldNameTextField,field),data);
        sendTextToFormField(field,Keys.TAB);
    }
    public String getFormPlaceHolderValue(String field){
        return getAttribute(buildDynamicLocator(fieldNameLabel,field),"placeholder");
    }
    public String getFormFieldErrorLabel(String field){
        return getText(buildDynamicLocator(fieldNameErrorLabel, field));
    }

    public String getGenderFieldLabel(){
        return getText(genderListFieldLabel);
    }
    public void clickGenderField(){
        click(genderListField, "Gender dropdown field");
    }
    public void selectGender(String field){
        click(genderListField, "Gender dropdown field");
        click(buildDynamicLocator(genderSelect,field),"Select Gender "+field);
    }
    public void selectUserTypeCompany(){
        click(userTypeCompanyRadio,"Company User Type");
    }
    public List<String> getGenderListValues(){
        return getMultipleValues(genderListOptions);
    }
    public String getPageHeading(){
        return getText(pageHeading);
    }
    public String getPageSubHeading(){
        return getText(pageSubHeading);
    }
    public String getUploadVehicleRegistrationUserJourney(){
        return getText(uploadVehicleRegistrationUserJourney);
    }
    public String getUploadPersonalInfoUserJourneyAttribute(String attribute){
        return getAttribute(uploadPersonalInfoUserJourney, attribute);
    }
    public boolean userTypePrivateSelection(){
        return isSelected(userTypePrivateRadioField);
    }
    public boolean userTypeCompanySelection(){
        return isSelected(userTypeCompanyRadioField);
    }
    public String getUserTypePrivateLabel(){
        return getText(userTypePrivateLabel);
    }
    public String getUserTypeCompanyLabel(){
        return getText(userTypeCompanyLabel);
    }
    public void selectUserTypeCompanyOption(){
        click(userTypeCompanyRadioField, "Company User type");
    }
    public boolean getProceedButtonVisibility(){
        return isEnabled(proceedButton);
    }
    public boolean getBackButtonVisibility(){
        return isEnabled(backButton);
    }
    public void submitPersonalInfoData(){
        click(proceedButton,"Proceed from Personal Info");
    }
    public void clickInfoTextIcon(String field){
        click(buildDynamicLocator(infoTextIcon,field),"Button click of icon+"+field);
    }
    public void closeInfoTextContainer(){
        click(infoTextContainerClose,"Close Info Text modal");
    }
    public boolean infoTextContainerExists(String field){
       return isDisplayed(buildDynamicLocator(infoTextContaier,field));
    }
    public boolean infoTextContainerInVisibility(){
        return isElementNotDisplayed(infoTextContaier);
    }
    public String getInfoTextTitle(){
       return getText(infoTextContainerTitle);
    }
    public String getInfoTextDescription(){
        return getText(infoTextContainerDescription);
    }
    public String getInfoTextDescription2(){
        return getText(infoTextContainerDescription2);
    }

}
