/**
 * 
 */
package org.javaeightstudies.javaconcurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.javaeightstudies.common.BaseJavaTest;

/**
 * @author niranjanb
 *http://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/
 */
public class CallableAndFuturesTest extends BaseJavaTest {
	
	private CallableAndFuturesTest(){}
	
	public static CallableAndFuturesTest getInstance(){
		CallableAndFuturesTest callableAndFuturesTest = new CallableAndFuturesTest();
		return callableAndFuturesTest;
	}
	
	public void letsGo(){
		// Callables are funcitonal interfaces just like runnables. But instead of being
		// void they return a value.
		Callable<Integer> task = () -> {
			try{
				TimeUnit.SECONDS.sleep(1);
				return 123;
			}
			catch(InterruptedException e){
				throw new IllegalStateException("task interrupted", e);
			}
		};
		
		// Passing a callable to the executor.
		ExecutorService executor = Executors.newSingleThreadExecutor();
		// For callbles executor returns a special result of type Future.
		Future<Integer> future = executor.submit(task);
		
		System.out.println("future done? " + future.isDone());
		
		try {
			Integer result = future.get();
			System.out.println("future done? " + future.isDone());
			System.out.println("result: "+ result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
