package apiDemoAppPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;

public class Preferences {
	
	public Preferences(AppiumDriver<AndroidElement> driver)
	{
//		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		 PageFactory.initElements(driver, this);
	}
	
//	@AndroidFindBy(xpath="//android.widget.TextView[@text='3. Preference dependencies']")
//	public WebElement dependencies;
	
	@FindBy(xpath="//android.widget.TextView[@text='3. Preference dependencies']")
	public WebElement dependencies;

}
