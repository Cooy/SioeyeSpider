package sioeye.spider.helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyHelpers {
	
	/**
	 * 获取properties文件对象
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
	 * 获取服务器api域名
	 * @return
	 */
	public String getServerUrl(){
		String serverurl = loadPro().get("serverurl").toString();
		return serverurl;
	}
	
	/**
	 * 获取服务器api doc url
	 * @return
	 */
	public String getApiDocUrl(){
		String apidocurl=loadPro().get("apidocurl").toString();
		return apidocurl;
	}

}
