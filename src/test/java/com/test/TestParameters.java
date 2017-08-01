package com.test;

import java.util.List;

import org.junit.Test;

import sioeye.spider.entities.ApiParameters;
import sioeye.spider.impl.DefaultApiParameterSpider;
import sioeye.spider.interfaces.IApiParametersSpider;


public class TestParameters {
	@Test
	public void testParameters(){
		IApiParametersSpider spider = new DefaultApiParameterSpider();
		List<ApiParameters> parameters = spider.getApiParameters("http://10.120.10.55:1000/classes/sharevidoes.html", "update_mini_video_title");
		for (ApiParameters parameter:parameters){
			System.out.println(parameter);
		}
	}
}
