package sioeye.spider.helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyHelpers {
	
	/**
	 * ��ȡproperties�ļ�����
	 * @return
	 * @throws Exception
	 */
	public Properties loadPro(){
		Properties properties = new Properties();
		FileInputStream fis=null;
		try {
			fis = new FileInputStream("property.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			properties.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}
	
	/**
	 * ��ȡ������api����
	 * @return
	 */
	public String getServerUrl(){
		String serverurl = loadPro().get("serverurl").toString();
		return serverurl;
	}
	
	/**
	 * ��ȡ������api doc url
	 * @return
	 */
	public String getApiDocUrl(){
		String apidocurl=loadPro().get("apidocurl").toString();
		return apidocurl;
	}

}
