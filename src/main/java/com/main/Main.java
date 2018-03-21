package com.main;

import cassandraHost.CassandraMain;
import cassandraHost.CassandraMain.CassandraConnect;

/**
 * 
 * @author andreasslovacek
 * @category class
 * @purpose Setup a test run of other packages
 */
public class Main {
	
	
	
	
	public Double mainDbl ;
	protected Integer mainInt ;
	private String mainStr ;
	
	
	
	
	// Constructor to fill in Main data for test
	public Main(){
		setMainDbl( 1.1 ) ;
		setMainInt( 1 ) ;
		setMainStr( "mainStr" ) ;
		
		
	}// end Main()
	
	
	
	
	// getters for all member variables
	public String getMainStr()	{ return this.mainStr ; }
	public Integer getMainInt()	{ return this.mainInt ; }
	public Double getMainDbl()	{ return this.mainDbl ; }
	
	
	
	
	// setter are protected
	protected void setMainStr(String str)	{ this.mainStr = str ; }
	protected void setMainInt(Integer inte)	{ this.mainInt = inte ; }
	protected void setMainDbl(Double dbl)	{ this.mainDbl = dbl ; }
	
	
	
	
	public static void main(String[] args) {
		CassandraMain cass = new CassandraMain() ;
		CassandraConnect cnxn = cass.new CassandraConnect() ;
		System.out.println("Port: " + cnxn.getPort() );

	}// end public static void main(String[] args)
	
	
	

}// end public class Main
