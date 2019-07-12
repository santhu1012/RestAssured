package SGTesting.com.RestAssuredFW;



import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import io.restassured.RestAssured;

public class RESTCalls 
{
	/*
	 This class will be responsible to fire a request
	 */
	
	private static Logger log = LogManager.getLogger(RESTCalls.class.getName());
	
	public static Response GETRequest(String uRI)
	{
		log.info("Inside get request call");
		RequestSpecification requestspecification = RestAssured.given();
		requestspecification.contentType(ContentType.JSON);
		Response response = requestspecification.get(uRI);
		log.debug(requestspecification.log().all());
		return response;
	}
	
	public static Response POSTRequest(String uRI,String strJSON)
	{
		log.info("Inside post request call");
		RequestSpecification requestspecification = RestAssured.given().body(strJSON);
		requestspecification.contentType(ContentType.JSON);
		Response response = requestspecification.post(uRI);
		log.debug(requestspecification.log().all());
		return response;
		
	}
	
	public static Response POSTRequest(String uRI,String strJSON,String sessionID)
	{
		log.info("Inside post request call");
		RequestSpecification requestspecification = RestAssured.given().body(strJSON);
		requestspecification.contentType(ContentType.JSON);
		requestspecification.header("cookie", "JSESSIONID="+sessionID+"");
		Response response = requestspecification.post(uRI);
		log.debug(requestspecification.log().all());
		return response;
		
	}
	public static Response PUTRequest(String uRI,String strJSON)
	{
		log.info("Inside put request call");
		RequestSpecification requestspecification = RestAssured.given().body(strJSON);
		requestspecification.contentType(ContentType.JSON);
		Response response = requestspecification.put(uRI);
		log.debug(requestspecification.log().all());
		return response;
	}
	
	public static Response DELETERequest(String uRI,String strJSON)
	{
		log.info("Inside delete request call");
		RequestSpecification requestspecification = RestAssured.given().body(strJSON);
		requestspecification.contentType(ContentType.JSON);
		Response response = requestspecification.delete(uRI);
		log.debug(requestspecification.log().all());
		return response;
		
	}
}
