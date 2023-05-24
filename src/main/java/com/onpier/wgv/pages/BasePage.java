package com.onpier.wgv.pages;

import com.onpier.wgv.utils.DriverManager;
import com.onpier.wgv.utils.ExtentReport;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BasePage {

   protected void click(By element, String elementName){
      explictWait(element).click();
      ExtentReport.getExtentTest().pass(elementName +" is clicked");
   }

   protected List<String> getMultipleValues(By element){
      List<WebElement> elements=DriverManager.driver.findElements(element);
      List<String> values=new ArrayList<>();
      for(WebElement elem : elements){
         values.add(elem.getText());
      }
      return values;
   }

   public String getText(By element){
      return explictWait(element).getText();
   }

   public String getAttribute(By element, String attribute){
      return explictWait(element).getAttribute(attribute);
   }

   public boolean isSelected(By element){
      return DriverManager.driver.findElement(element).isSelected();
   }
   public boolean isEnabled(By element){
      return explictWait(element).isEnabled();
   }
   public boolean isDisplayed(By element){
      return explictWait(element).isDisplayed();
   }

   protected WebElement explictWait(By element){
      WebDriverWait wait=new WebDriverWait(DriverManager.driver, Duration.ofSeconds(30));
      wait.until(ExpectedConditions.visibilityOfElementLocated(element));
      return DriverManager.driver.findElement(element);
   }

   public static boolean isElementNotDisplayed(By locator) {
      try {
         WebDriverWait wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
         return true;
      } catch (NoSuchElementException | TimeoutException e) {
         return false;
      }
   }
   protected void sendKeys(By locator, String text){
      explictWait(locator).sendKeys(text);
   }
   protected void sendKeys(By locator, Keys text){
      explictWait(locator).sendKeys(text);
   }

   protected void getAttribute(){

   }

   protected By buildDynamicLocator(By element, String dynamicText){
      String updatedLocator=element.toString().split("By.xpath: ")[1].trim().replace("DynamicText",dynamicText);
      return By.xpath(updatedLocator);
   }
}
