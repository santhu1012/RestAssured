package SGTesting.com.RestAssuredFW;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import SGTesting.com.utilities.PayloadConvertor;
import SGTesting.com.utilities.URL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LoginTest 
{
	Response response;
	private static Logger log = LogManager.getLogger(LoginTest.class.getName());
	
	@Test
	public void doLogin() throws Exception
	{
		log.info("starting test case: doLogin");
		String loginPayload = PayloadConvertor.generatePayloadString("JiraLogin.json");
		
		String endPointURI = URL.getEndPoint(""); 
		
		response = RESTCalls.POSTRequest(endPointURI, loginPayload);
		
		log.info(response.getBody().asString());
		
		String strResponse = response.getBody().asString();
		System.out.println("********Response JSON***********");
		System.out.println(strResponse);
		
		JsonPath jsonres = new JsonPath(strResponse);
		String sessionID = jsonres.getString("session.value");
		
		System.out.println(sessionID);
		log.info("JIRA JSession ID : "+ sessionID);
	}

}
