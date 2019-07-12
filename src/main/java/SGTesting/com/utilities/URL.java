package SGTesting.com.utilities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class URL
{
	
	public static final String URL = "";
	private static Logger log = LogManager.getLogger(URL.class.getName());
	
	public static String getEndPoint()
	{
		log.info("Base URI :"+ URL);
		return URL;
	}

	public static String getEndPoint(String resources)
	{
		log.info("URI End point :" + URL + resources);
		return URL+resources;
	}
}
