package sioeye.spider.interfaces;

import java.util.List;

import sioeye.spider.entities.Apis;

public interface IApiSpider {
	
	/**
	 * ��ȡ����һ���ӿڳ����µ�����api����()
	 * @param apidocurl
	 * @return{apiName,apiServerUrl}
	 */
	public List<Apis> getApi(String apidocurl);
}
