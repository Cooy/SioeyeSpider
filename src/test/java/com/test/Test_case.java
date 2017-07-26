package com.test;

import java.util.List;

import org.junit.Test;

import sioeye.spider.entities.Scenes;
import sioeye.spider.helpers.PropertyHelpers;
import sioeye.spider.impl.DefaultSceneSpider;
import sioeye.spider.interfaces.ISceneSpider;

public class Test_case {
	
	@Test
	public void test1(){
		ISceneSpider spider = new DefaultSceneSpider();
		PropertyHelpers ph = new PropertyHelpers();
		List<Scenes> scenes= spider.getScene(ph.getApiDocUrl());
		for(Scenes scene:scenes){
			System.out.println(scene);
		}
	}
}	
