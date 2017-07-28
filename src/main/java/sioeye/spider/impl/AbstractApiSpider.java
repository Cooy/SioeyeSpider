package sioeye.spider.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import sioeye.spider.entities.Apis;
import sioeye.spider.helpers.PropertyHelpers;
import sioeye.spider.interfaces.IApiSpider;

public class AbstractApiSpider implements IApiSpider {

	@Override
	public List<Apis> getApi(String apidocurl) {
		try {
			String result=crawlApi(apidocurl);
			Document doc=Jsoup.parse(result);
			//apiName,apiUrl
			Elements apiNameUrl=doc.select(".index-list.methods li a");
			List<Apis> apis= new ArrayList<>();
			for(Element a:apiNameUrl){
				Apis api=new Apis();
				String apiName= a.text();
				String apiServerUrl=new PropertyHelpers().getServerUrl()+apiName;
				api.setApiName(apiName);
				api.setApiServerUrl(apiServerUrl);
				api.setApiDocUrl(apidocurl);
				apis.add(api);
			}
			return apis;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * get接口文档html页面内容
	 * @param apidocurl
	 * @return
	 * @throws Exception
	 */
	protected  String crawlApi(String apidocurl) throws Exception{
		try(CloseableHttpClient  httpClient=HttpClientBuilder.create().build();
			CloseableHttpResponse httpResponse=httpClient.execute(new HttpGet(apidocurl))){
			String result=EntityUtils.toString(httpResponse.getEntity());
			return result;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
