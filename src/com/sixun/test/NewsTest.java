package com.sixun.test;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.sixun.dao.INewsDao;
import com.sixun.dao.IUserDao;
import com.sixun.dao.impl.NewsDaoImpl;
import com.sixun.dao.impl.UserDaoImpl;
import com.sixun.entity.News;
import com.sixun.entity.User;
import com.sixun.page.PageBean;
import com.sixun.page.PageUtils;
import com.sixun.util.JdbcUtils;


public class NewsTest {
	
	INewsDao dao =new NewsDaoImpl();
	@Test
	public void conn(){
		QueryRunner runner= JdbcUtils.getQueryRunner();
		System.out.println(runner);
	}
	@Test
	public void addNews(){
		
	
		dao.add(new News("photo1","Name", "realName", "男",123456, "course", "school", "profession", "education", "introduce"));
	}
	
	
	@Test
	public void updateNews(){
		
		dao.update(new News(3,"图片","用户名", "姓名", "女",1234, "课程", "学校", "专业", "学历", "介绍"));
		
	}
	
	@Test
	public void deleteNews(){
		dao.delete(4);
	}
	
	@Test
	public void getAll(){
		INewsDao dao =new NewsDaoImpl();
	List<News>	news = dao.getAll();
	for (News news2 : news) {
		System.out.println(news2);
	}
		
	}
	@Test
	public void getByid(){
		INewsDao dao =new NewsDaoImpl();
		News news = dao.getById(4);
		System.out.println(news);
	}
	
	@Test
	public void getByName(){
		INewsDao dao =new NewsDaoImpl();
		List<News>	news =	dao.getByName("userName");
		for (News news2 : news) {
			System.out.println(news2);
		}
	}
	
	@Test
	public void getByPage(){
		PageBean<News> pb= new PageBean<News>();
		String sql = "SELECT news.* FROM ";
		String condition = "news"+pb.getCondition().toString();
		PageUtils.getByPages(pb, News.class, sql, condition);
		
	}
}
