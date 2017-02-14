package com.sixun.service.impl;

import java.util.List;

import com.sixun.entity.News;
import com.sixun.page.Condition;
import com.sixun.page.PageBean;
import com.sixun.service.INewsService;
import com.sixun.util.StringUtils;

public class NewsServiceImpl implements INewsService {

	public boolean addNews(News news) {
		if (news == null) return false;
		return newDao.add(news);

	}
	
	public boolean updateNews(News news) {
		if (news == null) return false;
		return newDao.update(news);
	}
	
	public boolean deleteNews(String id) {
		if (StringUtils.checkNull(id)) return false;
		try {

			return newDao.delete(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			throw new RuntimeException("删除餐桌信息时传入的id为非数字");
		}
		
	}

	public List<News> getByName(String name) {
		if (StringUtils.checkNull(name)) {
			// select * from news
			return newDao.getAll();
		} else {
			// select * from news where username like '%name%'
			return newDao.getByName(name);
		}
	}

	public List<News> getAllNews() {
		 return newDao.getAll();
	}

	public News getNewsById(String id) {
		if (StringUtils.checkNull(id))
			return null;
		try {
			return newDao.getById(Integer.parseInt(id));
		} catch (Exception e) {
			throw new RuntimeException("根据id查询档案信息时，id为非数字");
		}
	}

	public PageBean<News> listNews(String pageNow, String typeName
			) {
		PageBean<News> pb = new PageBean<News>();
		if (!StringUtils.checkNull(pageNow)) {
			try {
				pb.setPageNow(Integer.parseInt(pageNow));
			} catch (NumberFormatException e) {
				throw new RuntimeException("分页查询档案信息时传入的页数为非数字");
			}
		}
		
		System.out.println("有没有在这里创建对象");
		 newDao.getByPage(pb);
		return pb;
		
	}

	public void getAllNews(PageBean<News> pb) {
		// TODO Auto-generated method stub
		
	}

}