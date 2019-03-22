package common;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class AppiumHelper {
	
	private static WebElement Element = null;
	public static WebElement FindElementById(AndroidDriver<MobileElement> driver,String ID) {
		Element=driver.findElementById(ID);
		return Element;
	}
	public static WebElement FindElementByXpath(AndroidDriver<MobileElement> driver,String Xpath) {
		Element=driver.findElementByXPath(Xpath);
		return Element;
	}
	
	public void clickOnElementByXpath(AndroidDriver<MobileElement> driver,String Xpath) {
		AppiumHelper.FindElementByXpath(driver, Xpath).click();
		
	}
    public void clickOnElementByID(AndroidDriver<MobileElement> driver,String ID) {
    	AppiumHelper.FindElementById(driver, ID).click();
	}
   public void SendkeysById(AndroidDriver<MobileElement> driver,String ID,String Input) {
	   AppiumHelper.FindElementById(driver, ID).sendKeys(Input);
	
}
   public void SendkeysByXpath(AndroidDriver<MobileElement> driver,String Xpath,String Input) {
	   AppiumHelper.FindElementById(driver, Xpath).sendKeys(Input);
}
   public void ScrollToViewElement(AndroidDriver<MobileElement> driver,String element) {
	   driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + element +"\"));");
   }
   public void ScrollInMainPage(AndroidDriver<MobileElement> driver) {
	   (new TouchAction(driver))
       .press(PointOption.point(535, 1702)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
       .moveTo(PointOption.point(474, 642)).release().perform();
   }
public void GetToastMessage(AndroidDriver<MobileElement> driver) {
	WebElement ToastView = driver.findElementByXPath("//android.widget.Toast[1]");
    String ToastMessage = ToastView.getAttribute("name");
    System.out.println("Toast Message Displayed as : "+ToastMessage);
     if(ToastMessage.equalsIgnoreCase("Please Fix the Appointment First")) {
    	  System.out.println("Toast Message validation done");
      }
      else {
    	  System.out.println("Toast Message validation Not Done");
      }
}
public void IsToastMessageDisplayed(AndroidDriver<MobileElement> driver) {
	WebElement ToastView = driver.findElementByXPath("//android.widget.Toast[1]");
	if(ToastView.isDisplayed()) {
		
	}
}





}


