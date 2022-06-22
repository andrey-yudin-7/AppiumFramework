package ecommerceApp;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ecommerceAppPageObjects.FormPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import practise.AppiumFramework.TestData;
import practise.AppiumFramework.Utilities;
import practise.AppiumFramework.base;

@Listeners(resources.Listeners.class)
public class Ecommerce_tc_2 extends base {
	
	@Test(dataProvider="Ecommerce_InputData1",dataProviderClass=TestData.class, groups={"Smoke"})
	public void main(String nameFieldInput) throws IOException, InterruptedException, NoSuchFieldException {
		//Fill the form details and verify Toast error messages displayed appropriately for wrong inputs
		
		AndroidDriver<AndroidElement> driver = runCapabilities("GeneralStoreApp", false);
		
		FormPage formPage = new FormPage(driver);
		formPage.femaleOption.click();
		formPage.getCountrySelection().click();
		Utilities u = new Utilities(driver);
		u.scrollToText("Argentina");
		formPage.argentina.click();
		formPage.btnLetsShop.click();
		String toastMessage = formPage.toastMessage.getAttribute("name");
		Assert.assertEquals("Please enter your name", toastMessage);
	}
}
