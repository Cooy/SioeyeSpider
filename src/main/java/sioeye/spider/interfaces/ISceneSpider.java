package sioeye.spider.interfaces;

import java.util.List;

import sioeye.spider.entities.Scenes;

public interface ISceneSpider {
	public List<Scenes> getScene(String url);
}
