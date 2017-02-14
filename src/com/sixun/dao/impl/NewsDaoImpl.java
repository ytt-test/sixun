package com.sixun.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sixun.dao.INewsDao;
import com.sixun.entity.News;
import com.sixun.page.PageBean;
import com.sixun.page.PageUtils;
import com.sixun.util.JdbcUtils;

public class NewsDaoImpl implements INewsDao{
	
	QueryRunner runner= JdbcUtils.getQueryRunner();
	public boolean add(News t) {
		String sql="INSERT INTO news VALUES(null,?,?,?,?,?,?,?,?,?,?)";
		try {
			return runner.update(sql,t.getPhoto(),t.getUserName(),t.getRealName(),t.getGender(),t.getPhone(),t.getCourse(),t.getSchool(),t.getProfession(),t.getEducation(),t.getIntroduction())>=1;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean update(News t) {
		String sql = "UPDATE news SET photo=?,userName=?,realName=?,gender=?,phone=?,course=?, school=?,profession=?,education=?,introduction=? WHERE id=?";
		try {
		return	runner.update(sql,t.getPhoto(),t.getUserName(),t.getRealName(),t.getGender(),t.getPhone(),t.getCourse(),t.getSchool(),t.getProfession(),t.getEducation(),t.getIntroduction(),t.getId())>=1;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean delete(int id) {
		String sql="DELETE FROM news WHERE id=?";
		try {
		return 	runner.update(sql, id)>=1;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<News> getAll() {
		String sql="SELECT * FROM news";
		try {
		return	runner.query(sql, new BeanListHandler<News>(News.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	
	}

	public News getById(int id) {
		String sql="SELECT * FROM news WHERE id=?";
		try {
		return	runner.query(sql, new BeanHandler<News>(News.class), id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<News> getByName(String userName) {
		String sql="SELECT * FROM news WHERE userName LIKE ?";
			
			try {
			return	runner.query(sql, new BeanListHandler<News>(News.class), "%"+userName+"%");
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
	}
	
	public void getByPage1(PageBean<News> pb) {
			
		String sql = "SELECT * FROM ";
		String condition = " news order by id desc";
		PageUtils.getByPages(pb, News.class, sql, condition);
		
	}
	
	/**
	 * 分页查询方法
	 * 
	 * -- 分页查询语句
SELECT news.* FROM 
news,user WHERE user.id=news.id 
AND userName LIKE '%%' AND realName LIKE '%%' 
LIMIT 0,6;

-- 查询总记录数
SELECT COUNT(*) FROM 
news,user WHERE user.id=news.id
AND userName LIKE '%%' AND realName LIKE '%%';
	 */
	public void getByPage(PageBean<News> pb) {
		
		String sql = "SELECT news.* FROM ";
		String condition = " news";
		PageUtils.getByPages(pb, News.class, sql, condition);
		
	}

}
