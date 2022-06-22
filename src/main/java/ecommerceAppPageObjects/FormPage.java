package ecommerceAppPageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import resources.Log;

public class FormPage {
	
	public FormPage(AppiumDriver<AndroidElement> driver) throws NoSuchFieldException
	{
//		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	@FindBy(xpath="//*[@text='Female']")
	public WebElement femaleOption;
	
	@FindBy(id="android:id/text1")
	private WebElement countryDropDown;
	
	@FindBy(xpath="//*[@text='Argentina']")
	public WebElement argentina;
	
	@FindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public WebElement btnLetsShop;
	
	@FindBy(xpath="//android.widget.Toast[1]")
	public WebElement toastMessage;
	
	public WebElement getNameField()
	{
		//if we need some log or an additional step then it is better to create a method
		Log.debug("Trying to find the Name field");
		return nameField;
	}
	
	public WebElement getCountrySelection()
	{
		//if we need some log or an additional step then it is better to create a method
		Log.debug("Trying to find the Name field");
		return countryDropDown;
	}

}
