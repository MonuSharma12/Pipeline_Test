import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class TestNGRerunner 
{
	public static void main(String arg[])
	{

		
//		 TestNG testng = new TestNG();
//	        testng.setTestSuites(List.of("D:\\Shivam Download\\Eclipse Workspace\\CucumberFramework\\testng.xml")); // Specify the path to your testng.xml
//
//	        for (int i = 0; i < 2; i++) {
//	            System.out.println("Running iteration: " + (i + 1));
//	            testng.run();
//	            if (i < 1) { // Avoid sleeping after the last iteration
//	                System.out.println("Waiting for 5 minutes before the next run...");
//	                try {
//						Thread.sleep(30000);// Wait for 5 minutes (300,000 ms)
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} 
//	            }
//	}

		
		
		// LOOP CONDITION
		  TestNG testng = new TestNG();
	        testng.setTestSuites(List.of("D:\\Shivam Download\\Eclipse Workspace\\CucumberFramework\\testng.xml")); // Specify the path to your testng.xml

	        int totalIterations = 3;
	        int currentIteration = 0;
	        List<Integer> failedIterations = new ArrayList<>();

	        while (currentIteration < totalIterations) {
	            System.out.println("Running iteration: " + (currentIteration + 1));
	            try {
	                testng.run();
	                currentIteration++;
	            } catch (Exception e) {
	                System.err.println("An error occurred during iteration " + (currentIteration + 1));
	                e.printStackTrace();
	                failedIterations.add(currentIteration + 1); // Store failed iteration index (1-based)
	            }

	            if (currentIteration < totalIterations) {
	                System.out.println("Waiting for 30 minutes before the next run...");
	                try {
	                    Thread.sleep(30000); // Wait for 30 minutes
	                } catch (InterruptedException e) {
	                    System.err.println("Sleep interrupted during iteration " + (currentIteration + 1));
	                    e.printStackTrace();
	                }
	            }
	        }

	        System.out.println("All iterations completed.");
	        System.out.println("Failed iterations: " + failedIterations);
	    }
	}
		