/**
 * 
 */
package org.javaeightstudies.languageenchancements;

/**
 * @author niranjanb
 *
 */
public class LanguageEnhancements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		PreBuildFunctionsTest.getInstance().letsGo();
		System.out.println("----------------------------");
		TryWithResourcesTest tryWithResourcesTest = TryWithResourcesTest.getInstance();
		tryWithResourcesTest.letsGo();
		System.out.println("----------------------------");
		tryWithResourcesTest.exceptionIntry();
		System.out.println("----------------------------");
		tryWithResourcesTest.exceptionIntryExceptionInCloseable();
		System.out.println("----------------------------");
	}

}
