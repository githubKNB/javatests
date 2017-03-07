/**
 * 
 */
package org.javaeightstudies.javaconcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import org.javaeightstudies.common.BaseJavaTest;

/**
 * @author niranjanb
 * http://winterbe.com/posts/2015/04/30/java8-concurrency-tutorial-synchronized-locks-examples/
 */
public class LocksTest extends BaseJavaTest {

	private int count = 0;
	
	private LocksTest(){}
	
	public static LocksTest getInstance(){
		return new LocksTest();
	}
	
	void increment(){
		count++;
	}
	/* (non-Javadoc)
	 * @see org.javaeightstudies.common.BaseJavaTest#letsGo()
	 */
	@Override
	public void letsGo() {
		System.out.println("Locks test start");
		ExecutorService executor = Executors.newFixedThreadPool(2);
		IntStream.range(0,10000).forEach(i -> executor.submit(this::increment));
		
		executor.shutdown();
		
		System.out.println(count);
		System.out.println("Locks test complete");
	}

}
