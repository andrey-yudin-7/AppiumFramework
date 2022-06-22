package apiDemoApp;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import apiDemoAppPageObjects.ExpandableListsPage;
import apiDemoAppPageObjects.HomePage;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import practise.AppiumFramework.base;

@Listeners(resources.Listeners.class) 
public class ApiDemo_tc_4 extends base {

	@Test
	public void main() throws IOException, NoSuchFieldException, InterruptedException {

		//Long press, Tap and make sure that sample menu popup successfully
		AndroidDriver<AndroidElement> driver = runCapabilities("ApiDemosApp", false);
		
		HomePage homePage = new HomePage(driver);
		TouchAction<?> t = new TouchAction<>(driver);

		homePage.Views.click();

		ExpandableListsPage expListPage = new ExpandableListsPage(driver);
		WebElement expandList = driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
		t.tap(tapOptions().withElement(element(expandList))).perform();
		expListPage.customAdapter.click();
		
		WebElement peopleNames = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
		t.longPress(longPressOptions().withElement(element(peopleNames)).withDuration(ofSeconds(2))).release().perform();
		
		Assert.assertTrue(expListPage.sampleMenu.isDisplayed());

	}
}
