package sioeye.spider.interfaces;

import java.util.List;

import sioeye.spider.entities.ApiDetails;

public interface IApiDetails {
	
	/**
	 * ��ȡ�ӿڵ���ϸ��Ϣ�������ӿڵ��������������������������ͣ���ѡ�ȣ���������Ϣ
	 * @param apidocurl
	 * @param apiname
	 * @return
	 */
	public List<ApiDetails> getApiDetails(String apidocurl, String apiname);
}
