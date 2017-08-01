package com.test;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import sioeye.spider.entities.ApiDetails;
import sioeye.spider.helpers.SpiderHelpers;
import sioeye.spider.impl.DefaultApiDetailSpider;
import sioeye.spider.interfaces.IApiDetails;

public class TestApiDetails {
	@Test
	public void testApiDetails(){
		IApiDetails spider = new DefaultApiDetailSpider();
		List<ApiDetails> details=spider.getApiDetails("http://10.120.10.55:1000/classes/sharevidoes.html", "update_mini_video_title");
		for(ApiDetails detail : details){
			System.out.println(detail);
		}
	}
}