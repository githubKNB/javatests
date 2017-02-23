/**
 * 
 */
package org.javaeightstudies.javastreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author niranjanb
 * https://www.tutorialspoint.com/java8/java8_streams.htm
 */
public class JavaStreams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		System.out.println("Strings List: "+strings);
		System.out.println("");			
		  //Count empty strings	      
		  //java 7
		  System.out.println("Empty String count Java 7: " + emptyCountJava7(strings));
		  
		  //java 8
		  long emptyCount = strings.stream().filter(s -> s.isEmpty()).count();
		  System.out.println("Empty String count Java 8: " + emptyCount);
		  
		  //Eliminate empty strings
		  //java 7
		  System.out.println("=============================================");
		  System.out.println("Total Strings length: " + strings.size());
		  System.out.println("");
		  List<String> filteredStrings7 = removeEmptyStrings(strings);
		  System.out.println("Filtered Strings Length Java 7: " + filteredStrings7.size());
		  
		  //java 8
		  List<String> filteredStrings8 = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
		  System.out.println("Filtered Strings Length Java 8: " + filteredStrings8.size());
		  
		  //Merge strings
		  //java 7
		  System.out.println("Merged string value Java 7: " + mergeStringList(strings, ", "));
		  
		  //java 8
		  String mergedString = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(", "));
		  System.out.println("Merged string value Java 8: " + mergedString);
		  
		  System.out.println("=============================================");
		  //off to numbers
		  List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		  System.out.println("Numbers List : " + numbers);
		  System.out.println("");
		  
		  //Squares list
		  //java 7
		  List<Integer> squaresList7 = squaresList(numbers);
		  System.out.println("Squares List Java 7:" + squaresList7);
		  
		  //java 8
		  List<Integer> squaresList8 = numbers.stream().map(i -> i*i).distinct().collect(Collectors.toList());
		  System.out.println("Squares List Java 8:" + squaresList8);
	      
		  System.out.println("=============================================");
		  //Find stats in java 7
		  List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);
		  System.out.println("Numbers List for stats: " + integers);
		  System.out.println("");
		  System.out.println("Hightest number in List Java 7: " + getMax(integers));
		  System.out.println("Lowest number in List Java 7: " + getMin(integers));
		  System.out.println("Sum of all numbers in List Java 7: " + getSum(integers));
		  System.out.println("Average of all numbers in List Java 7: " + getAverage(integers));
		  System.out.println("");
		  
		  //Find stats in java 8
		  IntSummaryStatistics statsJava8 = integers.stream().mapToInt((x) -> x).summaryStatistics();
		  System.out.println("Hightest number in List Java 8: " + statsJava8.getMax());
		  System.out.println("Lowest number in List Java 8: " + statsJava8.getMin());
		  System.out.println("Sum of all numbers in List Java 8: " + statsJava8.getSum());
		  System.out.println("Average of all numbers in List Java 8: " + statsJava8.getAverage());
		  System.out.println("=============================================");
	}
	
	public static long emptyCountJava7(List<String> strings){
		
		long emptyStringCount = 0;
		
		for(String strValue : strings){
			
			if((strValue != null) && (strValue.trim().length() == 0)){
				emptyStringCount++;
			}
		}
		return emptyStringCount;
	}

	public static List<String> removeEmptyStrings(List<String> strings){
		
		List<String> newStrings = new ArrayList<String>();

		for(String strValue : strings){
			
			if((strValue != null) && (strValue.trim().length() > 0)){
				newStrings.add(strValue);
			}
		}
		
		return newStrings;
	}
	
	public static String mergeStringList(List<String> strings, String separator){
		
		StringBuilder mergedString = new StringBuilder();
		
		for(String strValue : strings){
			
			if((strValue != null) && !strValue.isEmpty()){
				
				if(mergedString.length() > 0){
					mergedString.append(separator);	
				}
				mergedString.append(strValue);
			}
		}
		
		return mergedString.toString();
	}
	
	public static List<Integer> squaresList(List<Integer> numbers){
		
		Set<Integer> squaresSet = new HashSet<Integer>();
		
		for(Integer integerVal: numbers){
			squaresSet.add(integerVal * integerVal);
		}
		
		ArrayList<Integer> squaresList = new ArrayList<Integer>();
		squaresList.addAll(squaresSet);
		return squaresList;
	}
	
	public static Integer getMax(List<Integer> numbers){
		Integer maxValue = Integer.MIN_VALUE;
		
		for(Integer integerVal: numbers){
			
			if(maxValue < integerVal){
				maxValue = integerVal;
			}
		}
		return maxValue;
	}
	
	public static Integer getMin(List<Integer> numbers){
		Integer minValue = Integer.MAX_VALUE;
		
		for(Integer integerVal: numbers){
			
			if(minValue > integerVal){
				minValue = integerVal;
			}
		}
		return minValue;
	}
	
	public static Integer getSum(List<Integer> numbers){
		Integer sumValue = 0;
		
		for(Integer integerVal: numbers){
			sumValue += integerVal;
		}
		return sumValue;
	}
	
	public static Integer getAverage(List<Integer> numbers){
		Integer sumValue = getSum(numbers);
		Integer average = sumValue/numbers.size();
		return average;
	}
}
