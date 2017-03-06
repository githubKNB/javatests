/**
 * 
 */
package org.javaeightstudies.javalambda.testrunnable;

import org.javaeightstudies.common.BaseJavaTest;

/**
 * @author niranjanb
 * http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Lambda-QuickStart/index.html
 */
public class RunnableTest extends BaseJavaTest {
	
	private RunnableTest(){}
	
	public static RunnableTest getInstance(){
		RunnableTest runnableTest = new RunnableTest();
		return runnableTest;
	}
	
	public void letsGo(){
		System.out.println("RunnableTest Start");
		
		//Anonymous runnable pre java 8
		Runnable r1 = new Runnable(){
			@Override
			public void run(){
				System.out.println("Hello from Pre Java 8");
			}
		};
		
		// Java 8 runnable
		Runnable r2 = () -> System.out.println("Hello from Java 8");
		
		System.out.println("RunnableTest End");
	}
}
