package SGTesting.com.RestAssuredFW;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import SGTesting.com.utilities.PayloadConvertor;
import SGTesting.com.utilities.TestUtils;
import SGTesting.com.utilities.URL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BaseTest 
{
	private static Logger log = LogManager.getLogger(BaseTest.class.getName());

	public static String doLogin() throws IOException
	{
		Response response;
		log.info("Starting a Test case : dologin");
		String loginPayload = PayloadConvertor.generatePayloadString("JiraLogin.json");
		
		String endPointURI = URL.getEndPoint();
		response = RESTCalls.POSTRequest(endPointURI, loginPayload);
		log.info(response.getBody().asString());
		String strResponse = TestUtils.getResponseString(response);
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);
		String sessionID = jsonRes.getString("session.value");
		log.info("JIRA JSession ID:"+ sessionID);
		return sessionID;
	}

}
