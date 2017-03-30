/**
 * 
 */
package org.javaeightstudies.javalambda.testcomparator.functiontest;

import org.javaeightstudies.common.BaseJavaTest;

/**
 * @author niranjanb
 *
 */
public class ApplyAsByteTest extends BaseJavaTest {

	private ApplyAsByteTest(){}
	
	public static ApplyAsByteTest getInstance(){
		ApplyAsByteTest applyAsByteTest = new ApplyAsByteTest();
		
		return applyAsByteTest;
	}
	
	/* (non-Javadoc)
	 * @see org.javaeightstudies.common.BaseJavaTest#letsGo()
	 */
	@Override
	public void letsGo() {
		short[] array = {(short) 1,(short) 2,(short) 3};
		byte[] transformedArray = transformedArray(array,s -> (byte) (s*2));
		
		byte[] expectedArray = {(byte)2, (byte)4, (byte)6};
		
		System.out.println("Transformed Array");
		for(int i = 0; i < transformedArray.length ; i++){
			System.out.println(transformedArray[i]);
		}
		System.out.println("---------------");
		System.out.println("Expected Array");
		for(int i = 0; i < expectedArray.length ; i++){
			System.out.println(expectedArray[i]);
		}
		System.out.println("---------------");
	}
	
	private byte[] transformedArray(short[] array, ShortToByteFunction function){
		byte[] transformedArray = new byte[array.length];
		
		for(int i = 0 ; i < array.length ; i++){
			transformedArray[i] = function.applyAsByte(array[i]);
		}
		return transformedArray;
	}

}
