package apiDemoApp;
import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import apiDemoAppPageObjects.DependenciesPage;
import apiDemoAppPageObjects.HomePage;
import apiDemoAppPageObjects.Preferences;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import practise.AppiumFramework.TestData;
import practise.AppiumFramework.base;

@Listeners(resources.Listeners.class) 
public class ApiDemo_tc_1 extends base{

	@Test(dataProvider="ApiDemoTest_InputData1",dataProviderClass=TestData.class)
	public void apiDemo(String input) throws IOException, NoSuchFieldException, InterruptedException 
	{
		AndroidDriver<AndroidElement> driver = runCapabilities("ApiDemosApp", false);
		
		HomePage h = new HomePage(driver);
		h.Preferences.click();
		Preferences p = new Preferences(driver);
		p.dependencies.click();
		
		DependenciesPage d = new DependenciesPage(driver);
		
		d.checkbox.click();
		d.settings.click();
		d.editTextField.sendKeys(input);
		d.buttons.get(1).click();
	}
}
