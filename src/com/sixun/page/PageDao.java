package com.sixun.page;

import java.util.List;

/**
 * ��ҳ����
 * @author Administrator
 *
 */
public interface PageDao<T>{

	/**
	 * ��ʲô����
	 *   pageNow
	 *   pageCount
	 * ����ʲôֵ
	 *   totalRows--�����ݿ��в�ѯ
	 *   totalPages
	 *   List<T>
	 *   
	 *   PageBean
	 */
	public List<T> getByPage(PageBean<T> pb,String parameter);
	
}
