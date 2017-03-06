/**
 * 
 */
package org.javaeightstudies.javalambda.testcomparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.javaeightstudies.common.BaseJavaTest;

/**
 * @author niranjanb
 *http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Lambda-QuickStart/index.html
 */
public class ComparatorTest extends BaseJavaTest {

	private ComparatorTest(){}
	
	public static ComparatorTest getInstance(){
		ComparatorTest comparatorTest = new ComparatorTest();
		return comparatorTest;
	}
	public void letsGo(){
		
		List<Person> personList = Person.createShortLst();
		
		// Using inner class to sort
		Collections.sort(personList,new Comparator<Person>(){

			@Override
			public int compare(Person o1, Person o2) {
				if(o1 != null && o2 != null){
					return o1.getSurName().compareTo(o2.getSurName());
				}
				return 0;
			}
		});
		
		System.out.println("Sorted Surnames Pre Java 8");
		for(Person person: personList){
			person.printName();
		}
		
		System.out.println("Using lambda");
		personList = Person.createShortLst();
		Collections.sort(personList,(Person o1, Person o2) -> o1.getSurName().compareTo(o2.getSurName()));
		
		for(Person person : personList){
			person.printName();
		}
		
		System.out.println("===========TO STRING after DESC===========");
		Collections.sort(personList,(Person o1, Person o2) -> o2.getSurName().compareTo(o1.getSurName()));
		for(Person person : personList){
			person.printName();
		}
	}
}
