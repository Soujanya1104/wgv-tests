package com.onpier.wgv.utils;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name="vehicleRegistrationData")
    public Object[][] vehicleRegistrationData(){
        return new Object[][]{{"E-PKW","Flex-Prämie","pic.png"}};
    }

    @DataProvider(name="personalInfoPrivatePerson")
    public Object[][] personalInfoPrivatePerson(){
        return new Object[][]{{"E-PKW","Flex-Prämie","pic.png","Frau","Anna","Schmidt","anna@gmail.com","Anna Schmidt","DE81100400000106512700"}};
    }

    @DataProvider(name="personalInfoCompany")
    public Object[][] personalInfoCompany(){
        return new Object[][]{{"E-PKW","Flex-Prämie","pic.png","Anna GmbH","DE123456789","Frau","Anna","Schmidt","anna@gmail.com","Anna Schmidt","DE81100400000106512700"}};
    }

}
