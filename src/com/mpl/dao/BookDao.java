package com.mpl.dao;

import java.util.ArrayList;

import com.mpl.entity.BookBean;

/**
 * dao层
 * @author 17软工莫培文
 *
 */
public interface BookDao {
	/**
	 * 获得指定 id 的内容 精确查询
	 * @param id book的id
	 * @return 返回 BookBean
	 */
	public BookBean selectBook(int id);
	
	/**
	 * 获得指定 bookName 的内容 模糊查询
	 * @param bookName 书名
	 * @return 返回 BookBean
	 */
	public BookBean selectBook(String bookName);
	
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
	
	/**
	 * 修改指定 id 的内容
	 * @param id book的id
	 * @param bookBean 修改的内容
	 */
	public void updateBook(BookBean bookBean);
	
	/**
	 * 获得book列表
	 * @return book列表
	 */
	public ArrayList<BookBean> selectBooks();
}