package sioeye.spider.helpers;

public class StringHelpers {
	/**
	 * ½«./urlÌæ»»Îª/url
	 * @param url   ./classes/appstartupmanage.html
	 * @return  /classes/appstartupmanage.html
	 */
	public String getDealString(String url){
		String dealString=null;
		dealString=url.replace("./","");
		return dealString;
	}
}
