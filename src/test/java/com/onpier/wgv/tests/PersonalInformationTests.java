package com.onpier.wgv.tests;

import com.onpier.wgv.pages.LandingPage;
import com.onpier.wgv.pages.PersonalInformationPage;
import com.onpier.wgv.pages.VehicleRegistrationPage;
import com.onpier.wgv.utils.ConfigReader;
import com.onpier.wgv.utils.Constants;
import com.onpier.wgv.utils.DataProviders;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PersonalInformationTests extends BaseTest {

    private LandingPage landingPage=new LandingPage();
    private VehicleRegistrationPage vehicleRegPage=new VehicleRegistrationPage();
    private PersonalInformationPage personalInfoPage=new PersonalInformationPage();

    Properties phraseProps;

    /**
     * @author - Soujanya Muka
     * @Description - This test validates the page content (fields, heading, subheadings, behavior of the
     * field visibility, enabled etc., in the Personal Info page
     * @param vehicleClass
     * @param model
     * @param vehicleCard
     */
    @Test(dataProvider = "vehicleRegistrationData", dataProviderClass = DataProviders.class)
   public void validatePersonalInfoPageContent(String vehicleClass, String model, String vehicleCard){
        phraseProps=ConfigReader.getPhraseProps();
        configVehicleRegistrationDetails(vehicleClass,model,vehicleCard);
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(personalInfoPage.getPageHeading(),phraseProps.getProperty("PERSONALINFO_PAGEHEADING"));
        softAssert.assertEquals(personalInfoPage.getPageSubHeading(),phraseProps.getProperty("PERSONALINFO_PAGESUBHEADING"));
        softAssert.assertEquals(personalInfoPage.getUploadVehicleRegistrationUserJourney(),"check");
        softAssert.assertEquals(personalInfoPage.getUploadPersonalInfoUserJourneyAttribute("aria-selected"),"true");
        softAssert.assertEquals(true, personalInfoPage.userTypePrivateSelection());
        softAssert.assertEquals(false, personalInfoPage.userTypeCompanySelection());
        softAssert.assertEquals(personalInfoPage.getUserTypePrivateLabel(),"Privatperson");
        softAssert.assertEquals(personalInfoPage.getUserTypeCompanyLabel(),"Unternehmen");
        softAssert.assertEquals(personalInfoPage.getProceedButtonVisibility(),false);
        softAssert.assertEquals(personalInfoPage.getBackButtonVisibility(),true);
        softAssert.assertAll();
    }

    /**
     * @author Soujanya Mukka
     * @Description This test validates the Personal Info - Private Person fields validation (Fields availability, Placeholder values, Mandatory check with error validation etc.,)
     * @param vehicleClass
     * @param model
     * @param vehicleCard
     */
    @Test(dataProvider = "vehicleRegistrationData", dataProviderClass = DataProviders.class)
    public void validatePersonalInfoPrivatePersonFields(String vehicleClass, String model, String vehicleCard){
        phraseProps=ConfigReader.getPhraseProps();
        configVehicleRegistrationDetails(vehicleClass,model,vehicleCard);
        SoftAssert softAssert=new SoftAssert();
        //Gender LABEL VALIDATION
        softAssert.assertEquals(personalInfoPage.getGenderFieldLabel(),phraseProps.getProperty("GENDER_PLACEHOLDER"));
        //FirstName LABEL VALIDATION
        softAssert.assertEquals(personalInfoPage.getFormPlaceHolderValue(phraseProps.getProperty("FIRSTNAME")),phraseProps.getProperty("FIRSTNAME_PLACEHOLDER"));
        //LastName LABEL VALIDATION
        softAssert.assertEquals(personalInfoPage.getFormPlaceHolderValue(phraseProps.getProperty("LASTNAME")),phraseProps.getProperty("LASTNAME_PLACEHOLDER"));
        //EmailAddress LABEL VALIDATION
        softAssert.assertEquals(personalInfoPage.getFormPlaceHolderValue(phraseProps.getProperty("EMAILADDRESS")),phraseProps.getProperty("EMAILADDRESS_PLACEHOLDER"));
        //AccountOwner LABEL VALIDATION
        softAssert.assertEquals(personalInfoPage.getFormPlaceHolderValue(phraseProps.getProperty("ACCOUNTOWNER")),phraseProps.getProperty("ACCOUNTOWNER_PLACEHOLDER"));
        //IBAN LABEL VALIDATION
        softAssert.assertEquals(personalInfoPage.getFormPlaceHolderValue(phraseProps.getProperty("IBAN")),phraseProps.getProperty("IBAN_PLACEHOLDER"));
        //Gender Field - Validate Gender List Values
        personalInfoPage.clickGenderField();
        List<String> genderValues=getGenderValues();
        softAssert.assertEquals(personalInfoPage.getGenderListValues(),genderValues);
        //First Name - Mandatory check and Error validation
        personalInfoPage.sendTextToFormField(phraseProps.getProperty("FIRSTNAME"), Keys.TAB);
        String error=personalInfoPage.getFormFieldErrorLabel(phraseProps.getProperty("FIRSTNAME")).trim();
        softAssert.assertEquals(error,phraseProps.getProperty("FIRSTNAME_MANDATORYERRORLABEL"));
        //Last Name - Mandatory check and Error validation
        personalInfoPage.sendTextToFormField(phraseProps.getProperty("LASTNAME"), Keys.TAB);
        error=personalInfoPage.getFormFieldErrorLabel(phraseProps.getProperty("LASTNAME")).trim();
        softAssert.assertEquals(error,phraseProps.getProperty("LASTNAME_MANDATORYERRORLABEL"));
        //Email Address - Mandatory check and Error validation
        personalInfoPage.sendTextToFormField(phraseProps.getProperty("EMAILADDRESS"), Keys.TAB);
        error=personalInfoPage.getFormFieldErrorLabel(phraseProps.getProperty("EMAILADDRESS")).trim();
        softAssert.assertEquals(error,phraseProps.getProperty("EMAILADDRESS_MANDATORYERRORLABEL"));
        //Account Owner - Mandatory check and Error validation
        personalInfoPage.sendTextToFormField(phraseProps.getProperty("ACCOUNTOWNER"), Keys.TAB);
        error=personalInfoPage.getFormFieldErrorLabel(phraseProps.getProperty("ACCOUNTOWNER")).trim();
        softAssert.assertEquals(error,phraseProps.getProperty("ACCOUNTOWNER_MANDATORYERRORLABEL"));
        //IBAN - Mandatory check and Error validation
        personalInfoPage.sendTextToFormField(phraseProps.getProperty("IBAN"), Keys.TAB);
        error=personalInfoPage.getFormFieldErrorLabel(phraseProps.getProperty("IBAN")).trim();
        softAssert.assertEquals(error,phraseProps.getProperty("IBAN_MANDATORYERRORLABEL"));
        softAssert.assertAll();
    }

    /**
     * @author Soujanya Mukka
     * @Description This test validates the Personal Info - Company fields validation (Fields availability, Placeholder values, Mandatory check with error validation etc.,)
     * @param vehicleClass
     * @param model
     * @param vehicleCard
     */
    @Test(dataProvider = "vehicleRegistrationData", dataProviderClass = DataProviders.class)
    public void validatePersonalInfoCompanyFields(String vehicleClass, String model, String vehicleCard){
        phraseProps=ConfigReader.getPhraseProps();
        configVehicleRegistrationDetails(vehicleClass,model,vehicleCard);
        SoftAssert softAssert=new SoftAssert();
        personalInfoPage.selectUserTypeCompany();
        softAssert.assertEquals(personalInfoPage.getFormPlaceHolderValue(phraseProps.getProperty("COMPANYNAME")),phraseProps.getProperty("COMPANYNAME_PLACEHOLDER"));
        softAssert.assertEquals(personalInfoPage.getFormPlaceHolderValue(phraseProps.getProperty("VATID")),phraseProps.getProperty("VATID_PLACEHOLDER"));
        //Account Owner - Mandatory check
        personalInfoPage.sendTextToFormField(phraseProps.getProperty("COMPANYNAME"), Keys.TAB);
        String error=personalInfoPage.getFormFieldErrorLabel(phraseProps.getProperty("COMPANYNAME")).trim();
        softAssert.assertEquals(error,phraseProps.getProperty("COMPANYNAME_MANDATORYERRORLABEL"));
        //IBAN - Mandatory check
        personalInfoPage.sendTextToFormField(phraseProps.getProperty("VATID"), Keys.TAB);
        error=personalInfoPage.getFormFieldErrorLabel(phraseProps.getProperty("VATID")).trim();
        softAssert.assertEquals(error,phraseProps.getProperty("VATID_MANDATORYERRORLABEL"));
        //Company Name - Info Text modal validation
        personalInfoPage.clickInfoTextIcon(phraseProps.getProperty("COMPANYNAME"));
        softAssert.assertEquals(personalInfoPage.infoTextContainerExists(phraseProps.getProperty("COMPANYNAME")),true);
        softAssert.assertEquals(personalInfoPage.getInfoTextTitle(),phraseProps.getProperty("COMPANYNAMEINFO_TITLE"));
        softAssert.assertEquals(personalInfoPage.getInfoTextDescription(),phraseProps.getProperty("COMPANYNAMEINFO_DESCRIPTION"));
        softAssert.assertEquals(personalInfoPage.getInfoTextDescription2(),phraseProps.getProperty("COMANYNAMEINFO_DESCRIPTION2"));
        personalInfoPage.closeInfoTextContainer();
        //Validating the InfoText container is closed
        softAssert.assertEquals(personalInfoPage.infoTextContainerInVisibility(),true);
    }

    /**
     * @author Soujanya Mukka
     * @Description This method returns the gender field values. *It can be maintained from test data too
     * @return
     */
    public List<String> getGenderValues(){
        List<String> genderValues=new ArrayList<>();
        genderValues.add("Herr");
        genderValues.add("Frau");
        genderValues.add("Divers");
        return genderValues;
    }

    /**
     * @author Soujanya Mukka
     * @Description This test does the field validations like fields not allowing numerics,field formats etc.,
     * @param vehicleClass
     * @param model
     * @param vehicleCard
     */
    @Test(dataProvider = "vehicleRegistrationData", dataProviderClass = DataProviders.class)
    public void validatePersonalInfoFieldValidations(String vehicleClass, String model, String vehicleCard){
        phraseProps=ConfigReader.getPhraseProps();
        configVehicleRegistrationDetails(vehicleClass,model,vehicleCard);
        SoftAssert softAssert=new SoftAssert();
        //Validation First Name doesn't allow numbers and field level error message
        String field=phraseProps.getProperty("FIRSTNAME");
        personalInfoPage.sendTextToFormField(field,"123");
        String error=personalInfoPage.getFormFieldErrorLabel(field).trim();
        softAssert.assertEquals(error,phraseProps.getProperty("FIRSTNAME_MANDATORYERRORLABEL"));
        softAssert.assertEquals(personalInfoPage.getFormFieldText(field),"");
        //Validation First Name field doesn't accept more than 50 characters
        personalInfoPage.sendTextToFormField(field,"a".repeat(55));
        softAssert.assertEquals(personalInfoPage.getFormFieldText(field).length(),50);
        personalInfoPage.sendTextToFormField(field,"123");
        //Validation Last Name doesn't allow numbers and field level error message
        personalInfoPage.sendTextToFormField(phraseProps.getProperty("LASTNAME"),"123");
        error=personalInfoPage.getFormFieldErrorLabel(phraseProps.getProperty("LASTNAME")).trim();
        softAssert.assertEquals(error,phraseProps.getProperty("LASTNAME_MANDATORYERRORLABEL"));
        softAssert.assertEquals(personalInfoPage.getFormFieldText(phraseProps.getProperty("LASTNAME")),"");
        //Validation Account numbers doesn't allow numbers at the beginning and field level error message
        personalInfoPage.sendTextToFormField(phraseProps.getProperty("ACCOUNTOWNER"),"123");
        error=personalInfoPage.getFormFieldErrorLabel(phraseProps.getProperty("ACCOUNTOWNER")).trim();
        softAssert.assertEquals(error,phraseProps.getProperty("ACCOUNTOWNER_MANDATORYERRORLABEL"));
        softAssert.assertEquals(personalInfoPage.getFormFieldText(phraseProps.getProperty("ACCOUNTOWNER")),"");
        //Validation IBAN doesn't allow numbers at the beginning and field level error message
        personalInfoPage.sendTextToFormField(phraseProps.getProperty("IBAN"),"123");
        error=personalInfoPage.getFormFieldErrorLabel(phraseProps.getProperty("IBAN")).trim();
        softAssert.assertEquals(error,phraseProps.getProperty("IBAN_MANDATORYERRORLABEL"));
        softAssert.assertEquals(personalInfoPage.getFormFieldText(phraseProps.getProperty("IBAN")),"");
        //Validation Email address is correctly formatted
        personalInfoPage.sendTextToFormField(phraseProps.getProperty("EMAILADDRESS"),"test");
        error=personalInfoPage.getFormFieldErrorLabel(phraseProps.getProperty("EMAILADDRESS")).trim();
        softAssert.assertEquals(error,phraseProps.getProperty("EMAILADDRESS_VALIDATIONERRORLABEL"));
        softAssert.assertAll();
    }

    /**
     * @author Soujanya Mukka
     * @Description This test submits the Personal Info - Private person
     * @param vehicleClass
     * @param model
     * @param vehicleCard
     * @param gender
     * @param firstName
     * @param lastName
     * @param email
     * @param accountOwner
     * @param IBAN
     */
    @Test(dataProvider = "personalInfoPrivatePerson", dataProviderClass = DataProviders.class)
    public void validatePersonalInfoPrivatePersonSubmit(String vehicleClass, String model, String vehicleCard, String gender, String firstName, String lastName, String email, String accountOwner, String IBAN){
        phraseProps=ConfigReader.getPhraseProps();
        configVehicleRegistrationDetails(vehicleClass,model,vehicleCard);
        personalInfoPage.selectGender(gender);
        personalInfoPage.sendTextToFormField(phraseProps.getProperty("FIRSTNAME"),firstName);
        personalInfoPage.sendTextToFormField(phraseProps.getProperty("LASTNAME"),lastName);
        personalInfoPage.sendTextToFormField(phraseProps.getProperty("EMAILADDRESS"),email);
        personalInfoPage.sendTextToFormField(phraseProps.getProperty("ACCOUNTOWNER"),accountOwner);
        personalInfoPage.sendTextToFormField(phraseProps.getProperty("IBAN"),IBAN);
        //personalInfoPage.submitPersonalInfoData();

    }

    /**
     * @author Soujanya Mukka
     * @Description This test submits the Personal Info - Company
     * @param vehicleClass
     * @param model
     * @param vehicleCard
     * @param companyName
     * @param vatId
     * @param gender
     * @param firstName
     * @param lastName
     * @param email
     * @param accountOwner
     * @param IBAN
     */
    @Test(dataProvider = "personalInfoCompany", dataProviderClass = DataProviders.class)
    public void validatePersonalInfoCompanySubmit(String vehicleClass, String model, String vehicleCard, String companyName, String vatId, String gender, String firstName, String lastName, String email, String accountOwner, String IBAN){
        phraseProps=ConfigReader.getPhraseProps();
        configVehicleRegistrationDetails(vehicleClass,model,vehicleCard);
        personalInfoPage.selectUserTypeCompany();
        personalInfoPage.sendTextToFormField(phraseProps.getProperty("COMPANYNAME"), companyName);
        personalInfoPage.sendTextToFormField(phraseProps.getProperty("VATID"), vatId);
        personalInfoPage.selectGender(gender);
        personalInfoPage.sendTextToFormField(phraseProps.getProperty("FIRSTNAME"),firstName);
        personalInfoPage.sendTextToFormField(phraseProps.getProperty("LASTNAME"),lastName);
        personalInfoPage.sendTextToFormField(phraseProps.getProperty("EMAILADDRESS"),email);
        personalInfoPage.sendTextToFormField(phraseProps.getProperty("ACCOUNTOWNER"),accountOwner);
        personalInfoPage.sendTextToFormField(phraseProps.getProperty("IBAN"),IBAN);
        //personalInfoPage.submitPersonalInfoData();
    }

    /**
     * @author Soujanya Mukka
     * @Description This test submits vehicle registration details
     * @param vehicleClass
     * @param model
     * @param vehicleCard
     */
    public void configVehicleRegistrationDetails(String vehicleClass, String model, String vehicleCard){
        landingPage.selectVehicleClassOption(vehicleClass);
        landingPage.selectPremiumModelOption(model);
        String file=System.getProperty("user.dir").concat(Constants.RESOURCESPATH.concat(vehicleCard));
        vehicleRegPage.uploadVehicleRegCardFrontUpload(file);
        vehicleRegPage.uploadVehicleRegCardBackUpload(file);
        vehicleRegPage.submitVehicleRegPage(phraseProps.getProperty(Constants.PROCEED));
    }
}
