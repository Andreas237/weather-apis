package com.cassandraHost_test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.datastax.driver.core.exceptions.NoHostAvailableException;

import static org.junit.Assert.*;


import cassandraHost.CassandraMain;
import cassandraHost.CassandraMain.CassandraConnect;

/**
 * 
 * @author andreasslovacek
 * @category class
 */
public class CassandraMain_test {
	
	static CassandraConnect tester ;
	 
	
	
	
	
	// Test that the class members are null before class instantiation
	@BeforeClass
	public static void beforeNull_test() {
		assertNull( tester ) ;
	}// end public static void clusterNull_test()
	
	
	
	
	// Test that the session is empty
	// Node: node location in Docker container
	// Port: port number in Docker container
	@BeforeClass
	public static void testSetup() {
		CassandraMain x = null ;
		
		tester = x.new CassandraConnect() ;
		
	}// end public static void testSetup()
	
	
	
	
	// Test that the connection variables are empty
	@AfterClass
	  public static void testCleanup() {
	    // TODO: Do your cleanup here like close URL connection , releasing resources etc
		assertNotNull( tester.getSession() ) ;
		assertNotNull( tester.getCluster() ) ;
		System.out.println("Ran all the tests.\nCheck JUnit for results.") ;
	  }// end public static void testCleanup()
	
	
	
	
	/**
	 * TODO: 
	 * Can we connect to the table?	
	 * 	What happens if a column doesn't exist?
	 * 	What happens if we create a column that exists?
	 */
	
	
	
	
	// Check that we connected to the correct port and node
	@Test
	public void checkNodeAndPort_test() {
		// alternate ports on docker
		String testNode = "localhost" ;
		Integer testPort = 32768 ;
		// even if we can't connect we want to check that the node and port were set
		// by the private methods
		try{
			CassandraMain x = null ;
			tester = x.new CassandraConnect( testNode, testPort ) ;
		}
		catch( NoHostAvailableException e){
			System.out.println("Caught 'NoHostAvailableException' in checkNodeAndPort_test()");
			System.out.println("No need to panic, we're checking private methods.");
		}// end catch
		assertSame( tester.getNode() , testNode ) ;
		assertEquals( tester.getPort(), testPort ) ;
	}// end public void checkNodeAndPort_test()
	
	
	
	
	// Check that we connected to the correct port and node
	@Test
	public void checkNodeAndPortAndName_test() {
		// alternate ports on docker
		String testClusterName = "TEST_CLUSTER_NAME" ;
		String testNode = "localhost" ;
		Integer testPort = 32768 ; // another docker port
		// even if we can't connect we want to check that the node and port were set
		// by the private methods
		try{
			CassandraMain x = null ;
			tester = x.new CassandraConnect( testNode, testPort, testClusterName ) ;
		}
		catch( NoHostAvailableException e){
			System.out.println("Caught 'NoHostAvailableException' in checkNodeAndPortAndName_test()");
			System.out.println("No need to panic, we're checking private methods.");
		}// end catch
		
		assertSame( tester.getNode() , testNode ) ;
		assertEquals( tester.getPort(), testPort ) ;
		assertSame( tester.getClusterName(), testClusterName ) ;
	}// end public void checkNodeAndPort_test()
	
	
	
	
	// Test that neither the cluster or session are null
	// after the CassandraConnector constructor is called
	@Test
	public void connect_test() {
		assertNotNull( tester.getSession() ) ;
		assertNotNull( tester.getCluster() ) ;
		System.out.println( "Connected to a db.");
	}// end public static void duringNull_test()
	
	
	
	// that isClosed method works
	// Covers methods: isClosed(), close()
	@Test
	public void closed_test() {
		tester.close() ;
		assertTrue( tester.isClosed() ) ;
	}// end public void isClosed_test()
	
	
	
	/**
	 * @description Test that the fields are added to the map:
	 * 				1 is the field list empty?
	 * 				2 do we have the required fields 
	 */
	@Test
	public void fields_test() {
		// 1 is the field list empty?
		assertNotEquals( tester.getFields().size(), 0 ) ;
		// 2 do we have the required fields 
		assertNotNull( tester.getFields().keySet().contains("date") ) ;
		assertNotNull( tester.getFields().keySet().contains("zipcode") ) ;
		assertNotNull( tester.getFields().keySet().contains("forecast") ) ;
		assertNotNull( tester.getFields().keySet().contains("actual") ) ;
	}// end public void fields_test()
	
	
	
	// Test that we can create a table
	// TODO: create a KEYSPACE DB_TEST (equivalent to a DB
	// TODO: create a table TB_TEST in TEST
	// TODO: create some data in TB_TEST
	/**
	 * @description test that a keyspace can be created
	 */
	
	

}// end public class CassandraMain_test
