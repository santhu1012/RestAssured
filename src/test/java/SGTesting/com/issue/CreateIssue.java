package SGTesting.com.issue;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SGTesting.com.RestAssuredFW.Assertions;
import SGTesting.com.RestAssuredFW.BaseTest;
import SGTesting.com.RestAssuredFW.RESTCalls;
import SGTesting.com.utilities.PayloadConvertor;
import SGTesting.com.utilities.URL;
import io.restassured.response.Response;

public class CreateIssue 
{
	private String sessionID;
	Response response;
	
	private static Logger log = LogManager.getLogger(CreateIssue.class.getName());

	@BeforeMethod
	public void setUp() throws Exception
	{
		sessionID = BaseTest.doLogin();
	}
	
	@Test
	public void createIssue() throws Exception
	{
		log.info("Starting create issue");
		String URI = URL.getEndPoint("/rest/api/2/issue/");
		String createIssuePayload = PayloadConvertor.generatePayloadString("CreateBug.json");
		response = RESTCalls.POSTRequest(URI,  createIssuePayload , sessionID);
		Assertions.verifyStatusCode(response, 201);
	}
}
