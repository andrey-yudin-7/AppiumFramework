package apiDemoApp;
import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import apiDemoAppPageObjects.DependenciesPage;
import apiDemoAppPageObjects.HomePage;
import apiDemoAppPageObjects.Preferences;
import practise.AppiumFramework.base;

@Listeners(resources.Listeners.class) 
public class ApiDemo_tc_2 extends base{

	@Test
	public void main() throws IOException, NoSuchFieldException, InterruptedException  {
		
		//Basics test
		AndroidDriver<AndroidElement> driver = runCapabilities("ApiDemosApp", false);
		
		HomePage h = new HomePage(driver);
		h.Preferences.click();
		
		Preferences p = new Preferences(driver);

		p.dependencies.click();
		
		DependenciesPage d = new DependenciesPage(driver);
		
		d.checkbox.click();
		d.settings.click();
		d.editTextField.sendKeys("hello");
		d.buttons.get(1).click();
	}
}
