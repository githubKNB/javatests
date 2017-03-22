/**
 * 
 */
package org.javaeightstudies.languageenchancements;

import org.javaeightstudies.common.BaseJavaTest;

/**
 * @author niranjanb
 * http://www.journaldev.com/592/java-try-with-resources
 * Missed way too many questions on sample tests!!!!
 */
public class TryWithResourcesTest extends BaseJavaTest {

	private TryWithResourcesTest() {}
	
	public static TryWithResourcesTest getInstance(){
		TryWithResourcesTest tryWithResourcesTest = new TryWithResourcesTest();
		return tryWithResourcesTest;
	}
	/* (non-Javadoc)
	 * @see org.javaeightstudies.common.BaseJavaTest#letsGo()
	 */
	@Override
	public void letsGo() {
		try(MyResource mr = new MyResource()){
			System.out.println("MyResource created in try-with-resources");
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("out of try-catch block.");
	}
	
	public void exceptionIntry(){
		System.out.println("start exceptionIntry()");
		try(MyResource mr = new MyResource()){
			System.out.println("MyResource created in try-with-resources");
			if(mr != null){
				throw new Exception("Exception in try");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("end exceptionIntry()");		
	}

	public void exceptionIntryExceptionInCloseable(){
		System.out.println("start exceptionIntryExceptionInCloseable()");
		try(MyResourceWithException mr = new MyResourceWithException()){
			System.out.println("MyResource created in try-with-resources");
			if(mr != null){
				throw new Exception("Exception in try");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("end exceptionIntryExceptionInCloseable()");		
	}
	
	static class MyResource implements AutoCloseable{
		@Override
		public void close() throws Exception {
			System.out.println("Closing MyResource");
		}
	}

	static class MyResourceWithException implements AutoCloseable{
		@Override
		public void close() throws Exception {
			System.out.println("Closing MyResource");
			if(true){
				throw new Exception("Exception in Closeable");
			}
		}
	}
}
