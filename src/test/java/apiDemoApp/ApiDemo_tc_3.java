package apiDemoApp;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import apiDemoAppPageObjects.DragAndDropPage;
import apiDemoAppPageObjects.HomePage;
import apiDemoAppPageObjects.ViewsPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import practise.AppiumFramework.base;

@Listeners(resources.Listeners.class) 
public class ApiDemo_tc_3 extends base {

	@Test
	public void main() throws IOException, NoSuchFieldException, InterruptedException{
		//Drag and Drop the circle
		
		AndroidDriver<AndroidElement> driver = runCapabilities("ApiDemosApp", false);
		
		HomePage h = new HomePage(driver);
		ViewsPage v = new ViewsPage(driver);
		DragAndDropPage d = new DragAndDropPage(driver);
		
		h.Views.click();
		v.dragAndDrop.click();
		
		WebElement source = d.circlesList.get(0);
		WebElement destination = d.circlesList.get(1);
		TouchAction<?> t = new TouchAction<>(driver);
		t.longPress(element(source)).moveTo(element(destination)).release().perform();
	}
}
