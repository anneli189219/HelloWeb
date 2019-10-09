package com.mpl.dao;

import com.mpl.entity.BookBean;

public interface BookDao {
	/**
	 * 获得指定 id 的内容
	 * @param id book的id
	 * @return 返回 BookBean
	 */
	public BookBean selectBook(int id);
	
	/**
	 * 删除指定 id 的内容
	 * @param id book的id
	 */
	public void delBook(int id);
	
	/**
	 * 添加指定的内容到数据库
	 * @param BookBean 添加的内容
	 */
	public void addBook(BookBean bookBean);
}
