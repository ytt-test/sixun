package com.sixun.dao;

import com.sixun.entity.News;
import com.sixun.page.PageDao;
/**
 * @author tk
 *如果该类型还需要其他操作，可以在相关接口中继续添加
 */
public interface INewsDao extends BaseDao<News>, PageDao<News>{

}
