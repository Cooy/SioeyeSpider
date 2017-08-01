package sioeye.spider.interfaces;

import java.util.List;

import sioeye.spider.entities.ApiParameters;

public interface IApiParametersSpider {
	/**
	 * ��ȡ�ӿڵĴ�����ϸ��Ϣ
	 * @param apidocurl
	 * @param apiname
	 * @return {apiParameterName, apiParameterType, apiParameterFlag, apiParameterDesc}
	 */
	public List<ApiParameters> getApiParameters(String apidocurl,String apiname);
}
