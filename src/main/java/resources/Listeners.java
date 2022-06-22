package resources;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import practise.AppiumFramework.base;

public class Listeners extends base implements ITestListener {
	
//	ExtentReports extent = ExtentReporterNG.getReportObject();
//	ExtentTest test;
//	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
    @Override		
    public void onTestStart(ITestResult arg0) {					
//    	test = extent.createTest("Initial Demo");
//    	extentTest.set(test);
		log.debug("killing nodes");
		try {
			Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info("Killing nodes failed");
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.debug("Starting the server");
		service=startServer();
		log.info("Server started");
        		
    }
	
	@Override		
    public void onFinish(ITestContext arg0) {					
		//extent.flush();	
		log.debug("Stopping the server");
		service.stop();
		log.info("Server stopped");
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }		

    @Override		
    public void onStart(ITestContext arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailure(ITestResult result) {					
        // TODO Auto-generated method stub		
		//screenshot 
		String s=result.getName();
		try {
		base.getScreenshot(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.error("Cannot get a screenshot"); 
		}
		System.out.println("Test failed....Attention! Test name: " + result.getName());
        		
    }		

    @Override		
    public void onTestSkipped(ITestResult result) {					
        // TODO Auto-generated method stub

        		
    }		

    @Override		
    public void onTestSuccess(ITestResult arg0) {					
        // TODO Auto-generated method stub
    	//as example reports
    	//extentTest.get().log(Status.PASS, "Test passed");
    	
    }

}
