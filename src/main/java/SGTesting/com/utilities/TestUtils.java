 package SGTesting.com.utilities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class TestUtils 
{
	
	private static Logger log = LogManager.getLogger(TestUtils.class.getName());
	
	public static String getResponseString(Response response)
	{
		log.info("converting response to string");
		String strResponse = response.getBody().asString();
		log.debug(strResponse);
		return strResponse;
	}
	
	public static JsonPath jsonParser(String response)
	{
		log.info("parsing string response to JSON");
		JsonPath jsonResponse = new JsonPath(response);
		log.debug(jsonResponse);
		return jsonResponse;
	}
	
	public static XmlPath xmlParser(String response)
	{
		log.info("parsing string response to XML");
		XmlPath xmlResponse = new XmlPath(response);
		log.debug(xmlResponse);
		return xmlResponse;
		
	}
	
	public static int getStatusCode(Response response)
	{
		log.info("Getting response code");
		int statusCode = response.getStatusCode();
		log.info(statusCode);
		return statusCode;
	}
	
	public static String getStatusMessage(Response response)
	{
		log.info("Getting response message");
		String responseMessage = response.getStatusLine();
		log.info(responseMessage);
		return responseMessage;
	}
	
}
