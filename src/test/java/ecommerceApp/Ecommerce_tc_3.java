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
import practise.AppiumFramework.TestData;
import practise.AppiumFramework.Utilities;
import practise.AppiumFramework.base;

@Listeners(resources.Listeners.class)
public class Ecommerce_tc_3 extends base {

	@Test(groups={"Regression"}, dataProvider="Ecommerce_InputData1",dataProviderClass=TestData.class)
	public void main(String nameFieldInput) throws IOException, InterruptedException, NoSuchFieldException {
		//shop the items in the app by scrolling to specific Product and add to cart
		//validate if the items selected in the page 2 are matching with the items displayed in check out page

		AndroidDriver<AndroidElement> driver = runCapabilities("GeneralStoreApp", false);

		FormPage formPage = new FormPage(driver);
		formPage.getNameField().sendKeys(nameFieldInput);
		driver.hideKeyboard();
		formPage.femaleOption.click();
		formPage.getCountrySelection().click();
		Utilities u = new Utilities(driver);
		u.scrollToText("Argentina");
		formPage.argentina.click();
		formPage.btnLetsShop.click();
		
		ProductsPage productsPage = new ProductsPage(driver);
		
		System.out.println(productsPage.productName.size());
	
		u.scrollToText("Jordan 6 Rings");
		
		int count = productsPage.productName.size();

		for (int i = 0; i < count; i++) {
			String text = productsPage.productName.get(i).getText();
			if (text.equalsIgnoreCase("Jordan 6 Rings")) 
			{
				productsPage.addToCart.get(i).click();
				break;
			}
		}
		
		productsPage.buttonCart.click();
		Thread.sleep(4000);
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		String checkoutPageProductText = checkoutPage.productName.get(0).getText();
		Assert.assertEquals("Jordan 6 Rings", checkoutPageProductText);
	}
}
