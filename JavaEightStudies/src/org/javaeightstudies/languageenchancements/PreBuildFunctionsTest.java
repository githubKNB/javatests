/**
 * 
 */
package org.javaeightstudies.languageenchancements;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author niranjanb
 * https://www.oreilly.com/learning/java-8-functional-interfaces
 */
public class PreBuildFunctionsTest {

	public static void letsGo(){
		predicateTest();
		System.out.println("");
		System.out.println("=========================================");
		System.out.println("");
		functionTest();
		System.out.println("");
		System.out.println("=========================================");		
		consumerTest();
		System.out.println("");
		System.out.println("=========================================");
		supplierTest();
	}
	
	/**
	 * <p>
	 * Predicate.
	 * 
	 * A function for checking a condition. A <code>Predicate</code> is one such
	 * function accepting a single argument to evaluate to a boolean result.
	 * 
	 * It has a single method <code>test</code> which returns the boolean value.
	 * 
	 * <code>
	 * @FunctionalInterface
	 * public interface Predicate<T>{
	 * 	boolean test(T t);
	 * }
	 * </code>
	 * </p>
	 */
	public static void predicateTest(){
		Predicate<Integer> positive = i -> i > 0;
		
		List<Integer> integerList = Arrays.asList(1,10,200,101,-10,0);
		
		List<Integer> filteredList = integerList.stream()
					.filter(i -> positive.test(i)).collect(Collectors.toList());
		
		filteredList.forEach(System.out::println);
	}
	
	/**
	 * <p>
	 * Function
	 * 
	 * A <code>Function</code> is a functional interface whose sole purpose is to return any result by working on a
	 * single input argument.
	 * 
	 * It accepts an argument (T) and returns a result (R), by applying specified login on the input via
	 * the apply method.
	 * 
	 * <code>
	 * @FunctionalInterface
	 * public interface Function<T, R>{
	 * R apply(T t);
	 * }
	 * </code>
	 * 
	 * <code>Function</code> is used for transformation purposes, such as converting temperature from
	 * Centigrade to Fahrenheit, transforming a String to an Integer;
	 * </p> 
	 */
	public static void functionTest(){
		// convert centigrade to fahrenheit
		Function<Integer, Double> centigradeToFahrenheit = x -> new Double((x * 9/5) + 32);
		
		// String to an Integer
		Function<String, Integer> stringToInteger = x -> Integer.valueOf(x);
		
		//tests
		System.out.println("Centigrade 40 to Fahrenheit : " + centigradeToFahrenheit.apply(40));
		System.out.println("String to Integer : " + stringToInteger.apply("29"));
	}
	
	/**
	 * <p>
	 * Consumer
	 * 
	 * A <code>Consumer</code> accepts a single argument but does not return any result.
	 * 
	 * <code>
	 * @FunctionalInterface
	 * public interface Consumer<T>{
	 * void accept(T t);
	 * }
	 * </code>
	 * <br>
	 * <br> 
	 * This is mostly used to perform operations on the arguments such as persisting the employees, invoking
	 * house keeping operations, email newsletters;
	 * 
	 * http://www.java2s.com/Tutorials/Java/java.util.function/Consumer/index.htm
	 * </p>
	 */
	public static void consumerTest(){
		// Example 1
		Consumer<String> consumer1 = x -> System.out.println(x.toLowerCase());
		
		consumer1.accept("Consumer interface represents an operation");
		
		
		// Example 2
		int x = 99;
		Consumer<String> consumer2 = y -> {
			System.out.println("x : " + x);
			System.out.println("y : " + y);
			System.out.println("Some other lines...");
		};
		
		consumer2.accept("The following code shows how to create consumer with block statement.");
	}
	
	/**
	 * <p>Supplier
	 * 
	 * The <code>Supplier</code>, as the name suggests, supplies us with a result;
	 * 
	 * <code>
	 * @FunctionalInterface
	 * public interface Supplier<T>{
	 * T get();
	 * }
	 * </code>
	 * <br>
	 * <br>
	 * Example usage include fetching configuration values from the databse,
	 * loading with reference data, creating an list of students with default
	 * identifiers;
	 * 
	 * http://www.java2s.com/Tutorials/Java/java.util.function/Supplier/index.htm
	 * </p> 
	 * 
	 */
	public static void supplierTest(){
		
		//Example 1
		Supplier<String> i = () -> "java 8 supplier.";
		
		System.out.println(i.get());
		
		// Example 2
		class SunPower{
			public SunPower(){
				System.out.println("Sun Powder initialized.");
			}
		}
		
		Supplier<SunPower> sunPowerSupplier = () -> new SunPower();
		
		SunPower sp1 = sunPowerSupplier.get();
		SunPower sp2 = sunPowerSupplier.get();
		
		System.out.println("Are s1 and s2 objects equal ? " + Objects.equals(sp1, sp2));
	}
}
