package com.test;

import java.util.List;

import org.junit.Test;

import sioeye.spider.entities.Apis;
import sioeye.spider.impl.DefaultApiSpider;
import sioeye.spider.interfaces.IApiSpider;

public class TestApis {
	@Test
	//���Ի�ȡ��Ӧ�����µ�apiName,apiUrl�б� 
	public void testApis(){
		IApiSpider spider = new DefaultApiSpider();
		List<Apis> apis=spider.getApi("http://10.120.10.55:1000/classes/sharevidoes.html");
		for (Apis api:apis){
			System.out.println(api);
		}
		//apis.get(0).getApiName();��ȡ����Ϊ0��apis list��apiName
		//apis.get(0).getApiName();��ȡ����Ϊ0��apis list��apiUrl
	}
	
}
