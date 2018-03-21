package cassandraHost;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Cluster.Builder;
import com.datastax.driver.core.Session;
import com.google.gson.JsonObject;

import lombok.Data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

	
    
    
    
    

	
    
    
    
    /**
     * @fn main
     * @param args
     * @purpose Run the class so it can receive commandline args
     */
    public static void main( String[] args) {
    	CassandraMain x = null ;
    	CassandraConnect cnxn = x.new CassandraConnect() ;
    	
    }// end public static void main( String[] args)
    
    
    
    
    
    
    
    
    
    
    /**
     * @class CassandraConnect
     * @purpose Connect to the Cassandra DB
     */
    @Data
    public class CassandraConnect {
        
        
        
        
        
    	
    	private static final int HTTP_BAD_REQUEST = 400;
        private Cluster cluster;
        private Session session;
        private HashMap<String, Object> fields ;
        private final String clusterName ;
        private final String node ;
        private final Integer port ;
        public final String defaultClusterName = "weather-cluster" ;
        public final String defaultNode = "127.0.0.1" ;
        public final Integer defaultPort = 32769 ; //9042 maps to 32769 in docker
        
        
        
        
        /**
         * @category constructor
         * @description Setup the host session and connection with default
         * 				node and port
         */
        public CassandraConnect() {
        	this.clusterName = this.defaultClusterName ;
        	this.node = this.defaultNode ;
        	this.port = this.defaultPort ;
        	this.connect( defaultNode , defaultPort ) ;
        	this.fields = new OwmFields().getFields() ;    	
        }// end public CassandraHost()
        
        
        
        
        // Constructor with node as parameter
        public CassandraConnect( String _node ) {
        	this.clusterName = this.defaultClusterName ;
        	this.node = _node ;
        	this.port = this.defaultPort ;
        	this.connect( _node , defaultPort ) ;
        	this.fields = new OwmFields().getFields() ;
        }// end public CassandraConnector( String node )
        
        
        
        
        // Constructor with node and clusterName as parameters
        public CassandraConnect( String _node, String _clusterName ) {
        	this.clusterName = _clusterName ; 
        	this.node = _node ;
        	this.port = this.defaultPort ;
        	this.connect( _node , defaultPort ) ;
        	this.fields = new OwmFields().getFields() ;
        }// end public CassandraConnector( String node )
        
        
        
        
        // Constructor with port as parameter
        public CassandraConnect( Integer _port ) {
        	this.clusterName = this.defaultClusterName ;
        	this.node = this.defaultNode ;
        	this.port = _port ;
        	this.connect( defaultNode , _port ) ;
        	this.fields = new OwmFields().getFields() ;   	
        }// end public CassandraConnector( Integer port )
        
        
        
        
        // Constructor with node as parameter
        public CassandraConnect( String _node, Integer _port ) {
        	this.clusterName = this.defaultClusterName ;
        	this.node = _node ;
        	this.port = _port ;
        	System.out.println("NODE: " + this.node + "\tPORT: " + this.port ) ;
        	this.connect( _node , _port ) ;
        	this.fields = new OwmFields().getFields() ;
        }// end public public CassandraConnector( String node, Integer port )
        
        
        
        
        // Constructor with node as parameter
        public CassandraConnect( String _node, Integer _port, String _clusterName ) {
        	this.clusterName = _clusterName ;
        	this.node = _node ;
        	this.port = _port ;
        	System.out.println("NODE: " + this.node + "\tPORT: " + this.port ) ;
        	this.connect( _node , _port ) ;
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
        						.withClusterName( this.clusterName )
        					   .addContactPoint( node )
        					   .withPort( port ) ;
          	this.cluster = b.build() ;
        	this.session = cluster.connect() ;
        }// end public void connect( String node, Integer port)
        
        
        
        
        //  Create a connection
        protected void connect( String node ) {
        	Builder b = Cluster.builder()
        			.withClusterName( this.clusterName )
        			.addContactPoint( node )
        			.withPort( this.defaultPort );
        	this.cluster = b.build() ;
        	this.session = cluster.connect() ;
        }// end public void connect( String node )
        
        
        
        
        //  Create a connection
        protected void connect( Integer port ) {
        	
        	Builder b = Cluster.builder()
        			.withClusterName( this.clusterName )
        			.addContactPoint( this.defaultNode )
        			.withPort( this.defaultPort );    	
        	this.cluster = b.build() ;
        	this.session = cluster.connect() ;	
        }// end public void connect( String node )
        
        
        
        
        // Return TRUE if both the session and connection are closed
        public boolean isClosed() {
        	return this.cluster.isClosed() && this.session.isClosed() ;
        }// end isClosed()
        
        
        
        
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
        private class OwmFields {
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
    	
    }// end public class CassandraConnect
	
    
    
    
    
	
    
    
    
    /**
     * @class NewPostCurrentWeather	
     * @purpose Fields to match the Current API
     * 			http://openweathermap.org/current
     */
    @Data
    static class NewPostCurrentWeather {
    	private JsonObject coord ;
    	private JsonObject sys ; 
    	private List weather = new LinkedList<>();
    	private String base ;
    	private JsonObject main ;
    	private JsonObject wind ;
    	private JsonObject cloud ;
    	private Integer dt ;
    	private Integer id ;
    	private String name ; 
    	private Integer cod ;
    }// end class NewPostCurrentWeather
	
    
    
    
    
	
    
    
    
    /**
     * @class Model
     * @purpose implement methods
     */
    public static class Model {
    	private int nextId = 1 ;
    	private Map currentWeather = new HashMap<>() ;
    	
    	/**
    	 * @class CurrentWeather
    	 * @purpose data container for current weather API
    	 * 			http://openweathermap.org/current
    	 * 			Note: JSON isn't a supported type, therefore we'll store
    	 * 			 it as text. Otherwise migrate to Mongo.
    	 */
    	@Data
    	class CurrentWeather {
        	private JsonObject coord ;
        	private JsonObject sys ; 
        	private List weather ;
        	private String base ;
        	private JsonObject main ;
        	private JsonObject wind ;
        	private JsonObject cloud ;
        	private Integer dt ;
        	private Integer id ;
        	private String name ; 
        	private Integer cod ;
    	}// end class CurrentWeather
    	
    	
    }// end public static class Model
	
    
    
    
    
	
    
    
    
}// end public class CassandraHost
