package sioeye.spider.impl;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import sioeye.spider.entities.ApiParameters;
import sioeye.spider.helpers.SpiderHelpers;
import sioeye.spider.interfaces.IApiParametersSpider;

public class AbstractApiParametersSpider implements IApiParametersSpider {

	@Override
	public List<ApiParameters> getApiParameters(String apidocurl, String apiname) {
		List<ApiParameters> parameters=null;
		try {
			String result = new SpiderHelpers().crawl(apidocurl);
			Document doc=Jsoup.parse(result);
			Elements apiNameUrl=doc.select("#method_"+apiname+",.method item");
			Elements paramHtml = apiNameUrl.select(".params .param");
			//参数有paramsFlag和没有paramsFlag的时候，paramsName的元素定位不一样
			Elements paramsFlag=paramHtml.select(".param .flag.optional");
			//paramsFlag没有参数的时候
			if (paramsFlag.toString().length() <= 0 || paramsFlag.toString() == null){
				System.out.println("paramsFlag is NULL");
				Elements paramsDesc = paramHtml.select(".param-description p");
				Elements paramsName = paramHtml.select(".param .param-name");
				Elements paramsType = paramHtml.select(".param .type");
				parameters = new ArrayList<>();
				for (int i = 0; i<paramsName.size();i++){
					ApiParameters param = new ApiParameters();
					Element name = paramsName.get(i);
					Element desc = paramsDesc.get(i);
					Element type = paramsType.get(i);
					param.setApiParameterName(name.text());
					param.setApiParameterDesc(desc.text());
					param.setApiParameterType(type.text());
					parameters.add(param);
				}
			}else {
				//paramsFlag接口有参数的时候
				Elements paramsName= paramHtml.select(".param .param-name.optional");
				Elements paramsDesc = paramHtml.select(".param-description p");
				Elements paramsType = paramHtml.select(".param .type");
				parameters = new ArrayList<>();
				for (int i = 0; i < paramsName.size(); i++) {
					ApiParameters param = new ApiParameters();
					Element name = paramsName.get(i);
					Element desc = paramsDesc.get(i);
					Element type = paramsType.get(i);
					Element flag = paramsFlag.get(i);
					param.setApiParameterName(name.text());
					param.setApiParameterDesc(desc.text());
					param.setApiParameterType(type.text());
					param.setApiParameterFlag(flag.text());
					parameters.add(param);
				}
				
			}
		} catch (Exception e) {
			System.out.println("获取接口"+apiname+"参数失败");
			e.printStackTrace();
		}
		return parameters;
	}
	
}
