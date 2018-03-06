package com.cassandraHost_test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;


import cassandraHost.CassandraConnector;

/**
 * 
 * @author andreasslovacek
 * @category class
 */
public class CassandraConnector_test {
	
	static CassandraConnector tester ;
	
	
	
	
	// Test that the class members are null before class instantiation
	@BeforeClass
	public static void beforeNull_test() {
		assertNull( tester.getCluster() ) ;
		assertNull( tester.getSession() ) ;
	}// end public static void clusterNull_test()
	
	
	
	
	// Test that the session is empty
	@BeforeClass
	public static void testSetup() {
		tester = new CassandraConnector() ;
	}// end public static void testSetup()
	
	
	
	
	// Test that the connection variables are empty
	@AfterClass
	  public static void testCleanup() {
	    // TODO: Do your cleanup here like close URL connection , releasing resources etc
		assertNull( tester.getSession() ) ;
		assertNull( tester.getCluster() ) ;
	  }// end public static void testCleanup()
	
	
	
	
	/**
	 * TODO: 
	 * 	What happens if we are unable to connect?
	 * 	What happens if the database already exists?
	 * 	What happens if the database doesn't exist?
	 * 	What happens if a column doesn't exist?
	 * 	What happens if we create a column that exists?
	 */
	
	
	
	
	// Test whether a connection has been created
	@Test
	public static void duringNull_test() {
		assertNotNull( tester.getSession() ) ;
		assertNotNull( tester.getCluster() ) ;
	}// end public static void duringNull_test()
	

}// end public class CassandraHost_test
