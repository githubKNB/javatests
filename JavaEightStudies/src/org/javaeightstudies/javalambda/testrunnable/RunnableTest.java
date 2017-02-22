/**
 * 
 */
package org.javaeightstudies.javalambda.testrunnable;

/**
 * @author niranjanb
 * http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Lambda-QuickStart/index.html
 */
public class RunnableTest {
	public static void letsGo(){
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
