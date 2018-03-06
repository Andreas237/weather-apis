package cassandraHost;

	import com.datastax.driver.core.Cluster;
	import com.datastax.driver.core.Session;

/**
 * 
 * @author		andreasslovacek
 * @category	class
 * @purpose 	This class tries to connect to a cassandra database
 * 				and creates the database if it does not exist.
 * @description	Must create Cluster object to connect to Cassandra.
 * 				A node needs to be specified and port (default 9042)
 * 				can be specified.
 */
public class CassandraConnector {
	
	
    private Cluster cluster;
    
    private Session session;
    
    /**
     * @category constructor
     * Setup the host session
     * 
     */
    public CassandraConnector() {
    	
    }// end public CassandraHost()
	
	
	
	
	//  Create a connection
    public void connect( String node, Integer port){
    	
    }
	
	
	
	
	// getters for all member variables
    public Cluster getCluster()		{ return this.cluster ; }
    public Session getSession()	{ return this.session ; }
	
}// end public class CassandraHost
