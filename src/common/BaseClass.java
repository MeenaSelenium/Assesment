package common;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
    
	protected static AndroidDriver<MobileElement> driver ;

	protected static AppiumHelper helper=new AppiumHelper();
	@BeforeClass
	 public void setUp() throws MalformedURLException, InterruptedException{
			
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(CapabilityType.BROWSER_NAME,"");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
			caps.setCapability(MobileCapabilityType.UDID, "3c5c437");
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
			caps.setCapability("noReset", "true");
			caps.setCapability("unicodeKeyboard", "true");
			caps.setCapability("automationName", "UiAutomator2");
			//1.Launch the App
			caps.setCapability("appPackage", "com.pfizer.ie.EmotionSpace");
			caps.setCapability("appActivity", "com.pfizer.uk.emotion.views.registration.activities.SplashActivity");
			
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Thread.sleep(4000);
		//2.Tap on login button
			helper.clickOnElementByID(driver, "com.pfizer.ie.EmotionSpace:id/button_login");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		}
	@Test(dataProvider="GetCredentials")
	public void dkjfn(String Mail,String PWD) throws IOException {
			
		helper.clickOnElementByID(driver, "com.pfizer.ie.EmotionSpace:id/edit_text_enter_email");
		//3. Enter Email address :
		helper.SendkeysById(driver, "com.pfizer.ie.EmotionSpace:id/edit_text_enter_email", Mail);
		helper.clickOnElementByID(driver, "com.pfizer.ie.EmotionSpace:id/edit_text_login_pwd");
		//4. Enter Password:
		helper.SendkeysById(driver, "com.pfizer.ie.EmotionSpace:id/edit_text_login_pwd", PWD.trim());
		//5. Tap on Login
		helper.clickOnElementByID(driver, "com.pfizer.ie.EmotionSpace:id/button_login_next");
	//6. Tap on Emotion : happy
		helper.clickOnElementByXpath(driver, "//android.widget.TextView[@text='Happy']");
		//7. Move the scroll down
		helper.ScrollInMainPage(driver);
		//8. Tap on next
		helper.clickOnElementByID(driver, "com.pfizer.ie.EmotionSpace:id/button_select_intensity");
		//9. Tap on + icon beside 'why do you feel like that?' text
		helper.clickOnElementByID(driver, "com.pfizer.ie.EmotionSpace:id/text_view_add_cause");
		//10.Tap on 'Its my treatment'
		helper.clickOnElementByID(driver, "com.pfizer.ie.EmotionSpace:id/rl_item");
		//11.Tap on 'See more options'
		helper.clickOnElementByID(driver, "com.pfizer.ie.EmotionSpace:id/btn_see_more_option");
		//12. Scroll down and 
		helper.ScrollInMainPage(driver);
		//Tap on any one radio button to select a option
		helper.clickOnElementByID(driver, "com.pfizer.ie.EmotionSpace:id/checkbox_reason_child_item");
		//13.Tap on Save
				helper.clickOnElementByID(driver, "com.pfizer.ie.EmotionSpace:id/btn_done_widget");
			//15.Tap on + icon beside 'What might help?' text	
		helper.clickOnElementByID(driver, "com.pfizer.ie.EmotionSpace:id/image_need_check_mark");
		//16.Tap on 'See all options'
		helper.clickOnElementByID(driver, "com.pfizer.ie.EmotionSpace:id/button_see_all_needs");
		//17.Tap on 'My treatment' option
		helper.clickOnElementByXpath(driver, "//android.widget.TextView[@text='My treatment']");
		//I want to read up on my options//Scroll down and Tap on any one radio button to select a option
		helper.clickOnElementByXpath(driver, "//android.widget.RadioButton[@index='1']");
		//19.Tap on save
		helper.clickOnElementByID(driver, "com.pfizer.ie.EmotionSpace:id/btn_done_widget");
		//Tap on I'm finished
		helper.clickOnElementByID(driver, "com.pfizer.ie.EmotionSpace:id/btn_done_widget");
		//helper.clickOnElementByID(driver, "com.pfizer.ie.EmotionSpace:id/btn_skip_tutorial");
		helper.clickOnElementByXpath(driver, "//android.widget.ImageButton[@index='0']");
		//Tap on Hamberger menu
		//helper.clickOnElementByID(driver, "com.pfizer.ie.EmotionSpace:id/text_view_item_name");
		//Tap on My Profile
		helper.clickOnElementByXpath(driver, "//android.widget.TextView[@text='My profile']");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Tap On My Account
		helper.clickOnElementByID(driver, "com.pfizer.ie.EmotionSpace:id/text_view_my_account_header");
		//Tap on Log Out
		helper.clickOnElementByID(driver, "com.pfizer.ie.EmotionSpace:id/btn_view_sign_out");
		//Tap on Log Out
		helper.clickOnElementByID(driver, "android:id/button1");
			
		
	}
	@DataProvider (name ="GetCredentials")
	public Object[][] GetCredentials() throws IOException
	{
		FileInputStream fis = new FileInputStream("D:\\Assignment\\Credentials.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis); //get my workbook
	    XSSFSheet  sheet=workbook.getSheet("Sheet1");// get my sheet from workbook
	    int Row=sheet.getLastRowNum()+1;
	    System.out.println(Row);//get my Row which start from 0
	    int ColNum= sheet.getRow(0).getLastCellNum(); // get last ColNum
	    Object inputdata[][]= new Object[Row-2][ColNum-1]; // pass my count data in array
	    for (int i=2; i<=Row-1; i++) {
	  	        XSSFRow row = sheet.getRow(i);
	        for (int j=1; j<ColNum; j++) {
	             XSSFCell cell = row.getCell(j);
	        
	                 String value = String.valueOf(cell);    
	                inputdata[i-2][j-1] = value;
	                System.out.println("jj");
			         
	    
	        }}
	return inputdata;
	    }
	
@AfterClass
public void teardown() {
	driver.quit();
}
		
}
