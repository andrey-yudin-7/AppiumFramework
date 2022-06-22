package apiDemoApp;
import static java.time.Duration.ofSeconds;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import apiDemoAppPageObjects.DateWidgets;
import apiDemoAppPageObjects.HomePage;
import apiDemoAppPageObjects.ViewsPage;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import practise.AppiumFramework.base;

@Listeners(resources.Listeners.class)
public class ApiDemo_tc_6 extends base {

	@Test
	public void main() throws IOException, NoSuchFieldException, InterruptedException {
		// TODO Auto-generated method stub
		
		//swiping test
		AndroidDriver<AndroidElement> driver = runCapabilities("ApiDemosApp", false);
		
		HomePage homePage = new HomePage(driver);
		ViewsPage viewsPage = new ViewsPage(driver);
		DateWidgets dateWidgetsPage = new DateWidgets(driver);
		
		homePage.Views.click();
		viewsPage.dateWidgets.click();
		dateWidgetsPage.getDatetWidgetsOptions().get(1).click();
//		dateWidgetsPage.nineClock.click();
////		WebElement first = dateWidgetsPage.fifteenClock;
////		WebElement second = dateWidgetsPage.fourtFiveClock;
//
////		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
////		driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
////		driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
		driver.findElementByXPath("//*[@content-desc='9']").click();
		
		TouchAction<?> t = new TouchAction<>(driver);
		
		//long press //on element // 2 sec // move to another element and release
		WebElement first = driver.findElementByXPath("//*[@content-desc='15']");
		WebElement second = driver.findElementByXPath("//*[@content-desc='45']");
		t.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(2))).moveTo(element(second)).release().perform();
	}
}
