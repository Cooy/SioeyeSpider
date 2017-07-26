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
import sioeye.spider.helpers.StringHelpers;
import sioeye.spider.entities.Scenes;
import sioeye.spider.interfaces.ISceneSpider;

public class AbstractSceneSpider implements ISceneSpider {
	
	private static final String APIURL="http://10.120.10.55:1000/";
	
	/**
	 * get接口文档html页面内容
	 * @param url
	 * @return
	 * @throws Exception
	 */
	protected String crawl(String url) throws Exception{
		try(CloseableHttpClient  httpClient=HttpClientBuilder.create().build();
			CloseableHttpResponse httpResponse=httpClient.execute(new HttpGet(url))){
			String result=EntityUtils.toString(httpResponse.getEntity());
			return result;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	

	public List<Scenes> getScene(String url) {
		try {
			String result = crawl(url);
			Document doc = Jsoup.parse(result);
			Elements as = doc.select("#sidebar_list li a");
			List<Scenes> scenes = new ArrayList<>();
			for (Element a : as){
				Scenes scene = new Scenes(); 
				scene.setSceneName(a.text());
				scene.setSceneUrl(APIURL+new StringHelpers().getDealString(a.attr("href")));
				scenes.add(scene);
			}
			return scenes;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
