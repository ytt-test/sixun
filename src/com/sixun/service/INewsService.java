package com.sixun.service;

import java.util.List;

import com.sixun.entity.News;
import com.sixun.page.PageBean;

public interface INewsService extends BaseService{
	
	public boolean addNews(News t);
	public boolean updateNews(News t);
	public boolean deleteNews(String id);
	
	public  List<News> getAllNews();
	public List<News> getByName(String name);
	public void  getAllNews(PageBean<News> pb);
	public News getNewsById(String id);
	public PageBean<News> listNews(String pageNow,String pageCount);
	
	}
