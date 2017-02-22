package com.sixun.util;

public class StringUtils {
	
	/**
	 * �ַ����ǿ��ж�
	 * @param strings   ��Ҫ���зǿ��жϵ��ַ���
	 * @return      ��Щ�ַ����Ƿ�Ϊ��
	 *             true---------����Ϊnull�Ҳ�Ϊ���ַ���
	 */
	
	public static boolean checkNull(String...strings){
		
		if(strings==null) return true;
		
		for(String str:strings){
			if(str==null || str.length()==0){
			     return true;	
			}
		}
		return false;
	}
}
