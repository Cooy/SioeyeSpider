package sioeye.spider.helpers;

public class StringHelpers {
	/**
	 * ��./url�滻Ϊ/url
	 * @param url   ./classes/appstartupmanagehtml
	 * @return  /classes/appstartupmanagehtml
	 */
	public String getDealString(String url){
		String dealString=null;
		dealString=url.replace("./","");
		return dealString;
	}
}
