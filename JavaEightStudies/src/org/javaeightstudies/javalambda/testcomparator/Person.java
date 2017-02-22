/**
 * 
 */
package org.javaeightstudies.javalambda.testcomparator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niranjanb
 *
 */
public class Person {
	private String givenName;
	private String surName;
	private int age;
	private Gender gender;
	private String email;
	private String phone;
	private String address;
	
	/**
	 * @return the givenName
	 */
	public String getGivenName() {
		return givenName;
	}
	/**
	 * @param givenName the givenName to set
	 */
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	/**
	 * @return the surName
	 */
	public String getSurName() {
		return surName;
	}
	/**
	 * @param surName the surName to set
	 */
	public void setSurName(String surName) {
		this.surName = surName;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void printName(){
		System.out.println(givenName +" "+ surName);
	}
	
	public static List<Person> createShortLst(){
		List<Person> personList = new ArrayList();
		
		for(int i = 0 ; i < 10 ; i++){
			Person person = new Person();
			person.setAddress("Address "+i);
			person.setAge(20 + i);
			person.setEmail("email"+i+"@email.com");
			
			if((i%2)==0) {				
				person.setGender(Gender.FEMALE);
				person.setGivenName("Given Name");
				person.setSurName("Surname");
				person.setPhone("0000000");
			}
			else{
				person.setGender(Gender.MALE);
				person.setGivenName("Other Name");
				person.setSurName("Other Surname");
				person.setPhone("9999999");
			}
			
			personList.add(person);
		}
		
		return personList;
	}
	
	@Override
	public String toString() {
		return "Person [givenName=" + givenName + ", surName=" + surName + ", age=" + age + ", gender=" + gender
				+ ", email=" + email + ", phone=" + phone + ", address=" + address + "]";
	}
}
