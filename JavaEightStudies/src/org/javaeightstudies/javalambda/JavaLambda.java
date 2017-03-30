/**
 * 
 */
package org.javaeightstudies.javalambda;

import org.javaeightstudies.javalambda.testcomparator.ComparatorTest;
import org.javaeightstudies.javalambda.testcomparator.functiontest.ApplyAsByteTest;
import org.javaeightstudies.javalambda.testrunnable.RunnableTest;

/**
 * Just run. No jUnits
 * @author niranjanb
 *
 */
public class JavaLambda {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RunnableTest.getInstance().letsGo();
		System.out.println("=================================");
		ComparatorTest.getInstance().letsGo();
		System.out.println("=================================");
		ApplyAsByteTest.getInstance().letsGo();
		System.out.println("=================================");
	}

}
