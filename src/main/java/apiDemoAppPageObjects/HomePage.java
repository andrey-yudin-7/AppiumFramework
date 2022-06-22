package apiDemoAppPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;

public class HomePage {
	
	//1. Is to call the driver object from testcase to Pageobject file
	public HomePage(AppiumDriver<AndroidElement> driver) throws NoSuchFieldException
	{
//		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
		PageFactory.initElements(driver, this);
	}
	
	
//	@IOSFindBy(xpath="//android.widget.TextView[@text='Preference']")
//	public WebElement Preferences;
	
	@FindBy(xpath="//android.widget.TextView[@text='Preference']")
	public WebElement Preferences;
	
	@FindBy(xpath="//android.widget.TextView[@text='Views']")
	public WebElement Views;
	
}
