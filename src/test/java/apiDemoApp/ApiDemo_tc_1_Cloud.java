package apiDemoApp;
import java.io.IOException;

import org.testng.annotations.Test;

import apiDemoAppPageObjects.DependenciesPage;
import apiDemoAppPageObjects.HomePage;
import apiDemoAppPageObjects.Preferences;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import practise.AppiumFramework.TestData;
import practise.AppiumFramework.base;

public class ApiDemo_tc_1_Cloud extends base{


	@Test(dataProvider="InputData",dataProviderClass=TestData.class)
	public void apiDemo(String input) throws IOException, NoSuchFieldException, InterruptedException 
	{
		// TODO Auto-generated method stub
//		service=startServer();
		
		AndroidDriver<AndroidElement> driver = runCapabilities("ApiDemosApp", true);
		
		//xpath id classname, androidUIautomator
		/* xpath Syntax
		*	//tagname[@attribute='value']
		*/
		HomePage h = new HomePage(driver); //Constructor of class will be invoked when you create object for the class
		h.Preferences.click();
		//default constructor be called
		
		//constructor can be defined with arguments
		
		Preferences p = new Preferences(driver);
		
		//you can call the methods or variables of the class with class object
		p.dependencies.click();
		
		DependenciesPage d = new DependenciesPage(driver);
		
		d.checkbox.click();
		d.settings.click();
		d.editTextField.sendKeys(input);
		d.buttons.get(1).click();
//		service.stop();
	}
	
}
