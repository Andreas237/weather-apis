package cassandraHost;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Cluster.Builder;
import com.datastax.driver.core.Session;

import java.util.HashMap;

/**
 * 
 * @author		andreasslovacek
 * @category	class
 * @purpose 	This class tries to connect to a Cassandra database
 * 				and creates the database if it does not exist.
 * @description	Must create Cluster object to connect to Cassandra.
 * 				A node needs to be specified and port (default 9042)
 * 				can be specified.
 */
public class CassandraMain {
	
	
    private Cluster cluster;
    private Session session;
    private HashMap<String, Object> fields ;
    
    public final String defaultNode = "127.0.0.1" ;
    public final Integer defaultPort = 9042 ;
    
    /**
     * @category constructor
     * @description Setup the host session and connection with default
     * 				node and port
     */
    public CassandraMain() {
    	this.connect( defaultNode , defaultPort ) ;
    	this.fields = new OwmFields().getFields() ;    	
    }// end public CassandraHost()
	
	
	
	
	// Constructor with node as parameter
    public CassandraMain( String node ) {
    	this.connect( node , defaultPort ) ;
    	this.fields = new OwmFields().getFields() ;
    }// end public CassandraConnector( String node )
	
	
	
	
	// Constructor with port as parameter
    public CassandraMain( Integer port ) {
    	this.connect( defaultNode , port ) ;
    	this.fields = new OwmFields().getFields() ;   	
    }// end public CassandraConnector( Integer port )
	
	
	
	
	// Constructor with node as parameter
    public CassandraMain( String node, Integer port ) {
    	this.connect( node , port ) ;
    	this.fields = new OwmFields().getFields() ;
    }// end public public CassandraConnector( String node, Integer port )
	
	
	
	
	/**
	 * @method connect
	 * @description create a connection using the port and node
	 * 				in the object
	 * @param node
	 * @param port
	 */
    //  Create a connection
    public void connect( String node, Integer port) {
    	Builder b = Cluster.builder()
    					   .addContactPoint( node )
    					   .withPort( port ) ;
      	this.cluster = b.build() ;
    	this.session = cluster.connect() ;
    }// end public void connect( String node, Integer port)
	
	
	
	
	//  Create a connection
    public void connect( String node ) {
    	Builder b = Cluster.builder()
    			.addContactPoint( node )
    			.withPort( this.defaultPort );
    	this.cluster = b.build() ;
    	this.session = cluster.connect() ;
    }// end public void connect( String node )
	
	
	
	
	//  Create a connection
    public void connect( Integer port ) {
    	
    	Builder b = Cluster.builder()
    			.addContactPoint( this.defaultNode )
    			.withPort( this.defaultPort );    	
    	this.cluster = b.build() ;
    	this.session = cluster.connect() ;	
    }// end public void connect( String node )
	
	
	
	
	// getters for all member variables
    public Cluster getCluster()		{ return this.cluster ; }
    public Session getSession()	{ return this.session ; }
    public HashMap<String,Object> getFields() { return this.fields ; }
	
	
	
	
	// Return TRUE if both the session and connection are closed
    public boolean isClosed() {
    	return this.cluster.isClosed() && this.session.isClosed() ;
    }// end 
	
	
	
	
	// close the connection and session
    public void close() {
    	this.session.close() ;
    	this.cluster.close() ;
    }// end public void close()
	
    
    
    
    
    /**
     * @class OwmFields
     * @description this class fills in a map of the OWM
     * 				table's fields. With:
     * 				< fieldName, dataType>
     */
    private static class OwmFields {
    	public HashMap<String,Object> fields ;
    	protected OwmFields() {
    		fields = new HashMap<String, Object>() ;
    		this.fields.put("date", new String() ) ;
    		this.fields.put("zipcode", Integer.TYPE ) ;
    		this.fields.put("forecast_16day", new String() ) ;
    		this.fields.put("actual", new String() ) ;
    	}// end public OwmFields
    	
    	protected HashMap<String,Object> getFields(){ return this.fields ; }
    	
    }// end private static class OwmFields
	
	
	
}// end public class CassandraHost
