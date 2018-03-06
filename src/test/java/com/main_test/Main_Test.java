package com.main_test;


import com.main.*;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.*;


/**
 * 
 * @author andreasslovacek
 * @category class
 * @version 0.1
 * @purpose does nothing except construct an object for testing.
 */
public class Main_Test {
	
	 static Main tester ;
	

	  @BeforeClass
	  public static void testSetup() {
	    tester = new Main();
	  } // end public static void testSetup()
	 

	  
		 

	  /**
	   * Test each of the get methods asserting.
	   * This also checks that the default constructor and setter methods work
	   */
	  // noNull for mainStr
	  @Test
	  public void getMainStr_test() { assertNotNull( tester.getMainStr() ) ; }
		
		
		
		
		// equal to 1 for mainInt
	  @Test
	  public void getMainInt_test() { 
		  Integer []  actual = new Integer[1] ; // array containing actual value for test
		  actual[0] = tester.getMainInt() ;
		  
		  Integer [] expected = new Integer[1] ; // array containing expected value for test
		  expected[0] = 1 ;
		  
		  assertArrayEquals( actual, expected ) ; 
	  }// end public void getMainInt_test()
		
		
		
		
		// equal to 1.1 for mainDbl
	  @Test
	  public void getMainDbl_test() {  assertEquals( tester.getMainDbl() , 1.1, 0.00 ) ; }
		
		
		
		
}// end public class Main_Test
