package com.sixun.page;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sixun.util.JdbcUtils;


/**
 * ��ҳ������
 * @author Administrator
 *
 */
public class PageUtils {
	
	static QueryRunner runner = JdbcUtils.getQueryRunner();
	
	public static <T> List<T> getByPages(PageBean<T> pb,Class<T> t,String sql,String condition){
		String byPage = " LIMIT ?,?";
		
		//��ѯ�ܼ�¼��  totalRows----------totalPages��ֵ
		pb.setTotalRows(getToTalRows(condition));
		
		//�ж�һ��pageNow�Ƿ����    1~totalPages
		if(pb.getPageNow()<1){
			pb.setPageNow(1);
			System.out.println("�޸ĵ�ǰ��ҳ����1");
		}else if(pb.getPageNow()>pb.getTotalPages()){
			pb.setPageNow(pb.getTotalPages());
		}
		
		int start = (pb.getPageNow()-1)*pb.getPageCount();//0  6  12
		System.out.println("start------------"+start);
		
		//��ѯ�����  List<T>
		sql = sql.concat(condition).concat(byPage);
		System.out.println("��ҳ��ѯsql��"+sql);
		try {
			List<T> datas = runner.query(sql, new BeanListHandler<T>(t),start,pb.getPageCount());
			pb.setDatas(datas);
			return datas;
		} catch (SQLException e) {
			e.printStackTrace();
		}

	 return null;
	}
	
	//�����ܼ�¼��
	public static int getToTalRows(String condition) {
		String sql = "SELECT COUNT(*) FROM ";
		sql = sql.concat(condition);
		System.out.println("��ѯ�ܼ�¼����"+sql);
		try {
			//�ܼ�¼��
			Long count = runner.query(sql, new ScalarHandler<Long>());
			System.out.println("�ܼ�¼����"+count);
			return count.intValue();
		} catch (SQLException e) {
			throw new RuntimeException("��ѯ�ܼ�¼������");
		}
	}
	
}
