Genesis:
My initial web-services project, [NOAA_WebServices_Java](https://github.com/Andreas237/NOAA_WebServices_Java), became cumbersome and wasn't organized as well as could be.

This project aims to:
  - Connect to several weather APIs ([NOAA](https://www.ncdc.noaa.gov/cdo-web/webservices/v2#data), [OpenWeatherMap](https://openweathermap.org/api))
  - JUnit testing
  - Apache Cassandra in local Docker referring with a little [help](http://www.baeldung.com/cassandra-with-java)
  - Compare 5 day forecasts (stored in my DB) with the actuals
  - Use Apache Spark to gain insight


UML: Project outline [here](https://www.draw.io/?lightbox=1&highlight=0000ff&layers=1&nav=1&page=2&title=weather-apis%20UML.xml#Uhttps%3A%2F%2Fraw.githubusercontent.com%2FAndreas237%2Fweather-apis%2Fuml%2Fweather-apis%2520UML.xml) on draw.io.



/** TODO: DESIGN
		create UML diagram for classes and interfaces
	  		CassandraMain (class) - connects to DB, and tests connection, CRUD functions
	  		CassandraInterface (interface) - lists functions available for CassandraMain functionality
*/

/** TODO: TESTING
		Decide how to test the functionality decided in UML
			CassandraMain_test (class) - tests CassandraMain
*/

/** TODO: DEV
		TODO: Create classes according 

*/