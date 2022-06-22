package ecommerceApp;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ecommerceAppPageObjects.CheckoutPage;
import ecommerceAppPageObjects.FormPage;
import ecommerceAppPageObjects.ProductsPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import practise.AppiumFramework.Utilities;
import practise.AppiumFramework.base;

@Listeners(resources.Listeners.class)
public class Ecommerce_tc_6_Cloud extends base {

	@Test
	public void totalValidation() throws IOException, InterruptedException, NoSuchFieldException {
		// Validate the total amount displayed matched with the sum of product amount
		// selected for Shopping
//		service=startServer();
		AndroidDriver<AndroidElement> driver = runCapabilities("GeneralStoreApp", true);
		
		FormPage formPage = new FormPage(driver);
//		formPage.nameField.sendKeys("Hello");
		formPage.getNameField().sendKeys("Hello");
		driver.hideKeyboard();
		formPage.femaleOption.click();
		formPage.getCountrySelection().click();
		Utilities u = new Utilities(driver);
		u.scrollToText("Argentina");
//		driver.findElementsByAndroidUIAutomator(
//				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		formPage.argentina.click();
		formPage.btnLetsShop.click();
		
		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.addToCart.get(0).click();
		productsPage.addToCart.get(0).click();
		productsPage.buttonCart.click();
		Thread.sleep(4000);
		
		CheckoutPage checkoutPage = new CheckoutPage(driver);

		int count = checkoutPage.getProductList().size();
		double sum = 0;
		for (int i = 0; i < count; i++) {
			String amount1 = checkoutPage.getProductList().get(i).getText();
			double amount = getAmount(amount1);
			sum = sum + amount;
		}

		System.out.println("sum of products " + sum);

		String total = checkoutPage.totalAmount.getText();
		total = total.substring(1);
		double totalValue = Double.parseDouble(total);
		System.out.println("total value of products " + totalValue);
		Assert.assertEquals(sum, totalValue);
		service.stop();
		Thread.sleep(6000);
	}

	public static double getAmount(String value)

	{
		value = value.substring(1);
		double amount2value = Double.parseDouble(value);
		return amount2value;
	}

}
