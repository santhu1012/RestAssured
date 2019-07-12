package SGTesting.com.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class PayloadConvertor 
{
	
	private static Logger log = LogManager.getLogger(PayloadConvertor.class.getName());
	public static String generatePayloadString(String filename) throws IOException
	{
		log.info("Iside payloadconverter function");
		String filepath = System.getProperty("user.dir")+"\\Payloads\\"+filename;
		try
		{
			return new String(Files.readAllBytes(Paths.get(filename)));
		}
		catch(Exception e)
		{
			log.error(e);
			return null;
		}
		
	}

}
