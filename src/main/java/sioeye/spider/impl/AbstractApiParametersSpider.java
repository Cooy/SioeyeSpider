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
			//������paramsFlag��û��paramsFlag��ʱ��paramsName��Ԫ�ض�λ��һ��
			Elements paramsFlag=paramHtml.select(".param .flag.optional");
			//paramsFlagû�в�����ʱ��
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
				//paramsFlag�ӿ��в�����ʱ��
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
			System.out.println("��ȡ�ӿ�"+apiname+"����ʧ��");
			e.printStackTrace();
		}
		return parameters;
	}
	
}
