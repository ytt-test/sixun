package com.sixun.dao.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.dom4j.Document;
import org.dom4j.Element;

import com.sixun.dao.IUserDao;
import com.sixun.entity.News;
import com.sixun.entity.User;
import com.sixun.page.PageBean;
import com.sixun.util.JdbcUtils;

/**
 * IUserDao接口的实现类
 * 
 * @author 
 */
public class UserDaoImpl implements IUserDao {

	QueryRunner runner= JdbcUtils.getQueryRunner();
	public boolean add(User t) {
		String sql="INSERT INTO users VALUES(null,?,?,?,?,?)";
		try {
			return runner.update(sql, t.getUserName(),t.getPassword(),t.getPasswordAgain(),t.getPhone(),t.getEmail())>=1;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean update(User t) {
		String sql = "UPDATE dinnertable SET tableStatue=?,orderDate=? WHERE id=?";
		try {
		return	runner.update(sql,t.getUserName())>=1;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public boolean delete(int id) {
		String sql="DELETE FROM dinnertable WHERE id=?";
		try {
		return 	runner.update(sql, id)>=1;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<User> getAll() {
		String sql="SELECT * FROM dinnertable";
		try {
		return	runner.query(sql, new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	
	}

	public User getById(int id) {
		String sql="SELECT * FROM dinnertable WHERE id=?";
		try {
		return	runner.query(sql, new BeanHandler<User>(User.class), id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<User> getByName(String name) {
		String sql="SELECT * FROM dinnertable WHERE tableName LIKE ?";

			try {
			return	runner.query(sql, new BeanListHandler<User>(User.class), "%"+name+"%");
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
	}

	public void getByPage(PageBean<News> pb) {
		// TODO Auto-generated method stub
		
	}
	
}
