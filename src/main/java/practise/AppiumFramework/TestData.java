package practise.AppiumFramework;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name="ApiDemoTest_InputData1")
	public Object[][] getDataForEditField()
	{
		//2 sets of data, "hello", "buy"
		Object[][] obj = new Object[][]
				{
			{"hello"}, {"buy"}
			
			};
			
			return obj;
	}
	
	@DataProvider(name="Ecommerce_InputData1")
	public Object[][] getDataForNameField()
	{
		Object[][] obj = new Object[][]
				{
			{"hello1"}
			
			};
			
			return obj;
		
	}

}
