package sioeye.spider.interfaces;

import java.util.List;

import sioeye.spider.entities.Scenes;

public interface ISceneSpider {
	
	/**
	 * ��ȡapi doc scene list������scen��url��
	 * @param url
	 * @return
	 */
	public List<Scenes> getScene(String url);
}
