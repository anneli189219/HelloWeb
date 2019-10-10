package com.mpl.main;

import java.util.ArrayList;
import java.util.Iterator;

import com.mpl.dao.impl.BookDaoImpl;
import com.mpl.entity.BookBean;

/**
 * 对book表中的数据进行增删改查
 * 
 * @author mopeiwen
 * @version 2019年10月10日 下午3:40:54
 */
public class Main {

	static BookDaoImpl bookDaoImpl = new BookDaoImpl();
	static BookBean bookBean = new BookBean();
	
	public static void main(String[] args) {
		// 增加书本
		bookBean = new BookBean(3, "数据库命令集合", 99, "包括了sql和mysql的集合");
		bookDaoImpl.addBook(bookBean);
		printlnOf();// 输出book集合
		
		//修改书本信息
		bookBean = new BookBean(3, "数据库命令集合", 120, "包括了sql、mysql和甲骨文的集合");
		bookDaoImpl.updateBook(bookBean);
		printlnOf();// 输出book集合
		
		//删除书本
		bookDaoImpl.delBook(3);
		printlnOf();// 输出book集合
		
		//按序号查询书本信息
		System.out.println(bookDaoImpl.selectBook(2));
		
		//按书名查询书本信息
		System.out.println(bookDaoImpl.selectBook("书"));

	}

	/**
	 * 输出book集合
	 */
	public static void printlnOf() {
		ArrayList<BookBean> books = new ArrayList<BookBean>();
		books = bookDaoImpl.selectBooks();

		for (Iterator<BookBean> iterator = books.iterator(); iterator.hasNext();) {
			BookBean bookBean = (BookBean) iterator.next();
			System.out.println(bookBean);
		}
		System.out.println("#################################");
	}
}
