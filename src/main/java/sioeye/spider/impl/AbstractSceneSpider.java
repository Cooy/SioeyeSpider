package sioeye.spider.impl;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import sioeye.spider.entities.Scenes;
import sioeye.spider.helpers.PropertyHelpers;
import sioeye.spider.helpers.SpiderHelpers;
import sioeye.spider.helpers.StringHelpers;
import sioeye.spider.interfaces.ISceneSpider;

public class AbstractSceneSpider implements ISceneSpider {
	
	public List<Scenes> getScene(String url) {
		try {
			String result = new SpiderHelpers().crawl(url);
			Document doc = Jsoup.parse(result);
			Elements as = doc.select("#sidebar_list li a");
			List<Scenes> scenes = new ArrayList<>();
			for (Element a : as){
				Scenes scene = new Scenes(); 
				scene.setSceneName(a.text());
				scene.setSceneUrl(new PropertyHelpers().getApiDocUrl()+new StringHelpers().getDealString(a.attr("href")));
				scenes.add(scene);
			}
			return scenes;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
