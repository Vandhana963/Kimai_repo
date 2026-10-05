package genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtility{
	  FileInputStream fis;
		public String readDataFromPropertyFile(String key) throws Exception
		{
			fis=new FileInputStream("./src/main/resources/Commondata.properties");
			//fis=new FileInputStream("./src/main/resources/Commondata1.properties");
			Properties p=new Properties();
			p.load(fis);
			
			return p.getProperty(key);
			
		}
		
		
	

}
