Genesis:
My initial web-services project, [NOAA_WebServices_Java](https://github.com/Andreas237/NOAA_WebServices_Java), became cumbersome and wasn't organized as well as could be.

This project aims to:
  - Connect to several weather APIs ([NOAA](https://www.ncdc.noaa.gov/cdo-web/webservices/v2#data), [OpenWeatherMap](https://openweathermap.org/api))
  - Use Apache Cassandra referring with a little [help](http://www.baeldung.com/cassandra-with-java)
  - Compare 5 day forecasts (stored in my DB) with the actuals
  - Use Apache Spark to gain insight
