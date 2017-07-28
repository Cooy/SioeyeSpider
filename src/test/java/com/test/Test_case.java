package com.test;

import java.util.List;

import org.junit.Test;

import sioeye.spider.entities.Scenes;
import sioeye.spider.helpers.PropertyHelpers;
import sioeye.spider.impl.DefaultApiSpider;
import sioeye.spider.impl.DefaultSceneSpider;
import sioeye.spider.interfaces.IApiSpider;
import sioeye.spider.interfaces.ISceneSpider;

public class Test_case {
	
	@Test
	public void tesGetScene(){
		ISceneSpider spider = new DefaultSceneSpider();
		PropertyHelpers ph = new PropertyHelpers();
		List<Scenes> scenes= spider.getScene(ph.getApiDocUrl());
		for(Scenes scene:scenes){
			System.out.println(scene);
		}
		//获取相应的sceneName或者sceneUrl
		//scenes.get(0).getSceneName();
		//scenes.get(0).getSceneUrl();
	}
}	
