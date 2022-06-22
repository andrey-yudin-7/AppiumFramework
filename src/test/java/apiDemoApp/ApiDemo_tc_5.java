package apiDemoApp;
import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import practise.AppiumFramework.base;

@Listeners(resources.Listeners.class) 
public class ApiDemo_tc_5 extends base{

	@Test
	public void main() throws IOException, NoSuchFieldException, InterruptedException {
		// TODO Auto-generated method stub
		
		//Scrolling test
		AndroidDriver<AndroidElement> driver = runCapabilities("ApiDemosApp", false);
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		
		//Android API code, not Appium
		System.out.println(driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		
	}
}
