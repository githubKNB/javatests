/**
 * 
 */
package org.javaeightstudies.javaconcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.javaeightstudies.common.BaseJavaTest;

/**
 * @author niranjab
 * http://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/
 *
 */
public class ExecutorTest extends BaseJavaTest{

	private ExecutorTest(){}
	
	public static ExecutorTest getInstance(){
		ExecutorTest executorTest = new ExecutorTest();
		return executorTest;
	}
	
	public void letsGo(){
		// Executor test
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(() -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Hello " + threadName);
		});
		
		// Shutdown executors
		try{
			System.out.println("Attempt to shutdown executor");
			executor.shutdown();
			executor.awaitTermination(5, TimeUnit.SECONDS);
		}catch (InterruptedException e){
			System.out.println("Task interrupted");
		}
		finally{
			if(!executor.isTerminated()){
				System.out.println("cancel non-finished tasks");
			}
			executor.shutdownNow();
			System.out.println("Shutdown finished.");
		}
	}
}
