package com.mpl.dao;

import com.mpl.entity.BookBean;

public interface BookDao {
	/**
	 * ���ָ�� id ������
	 * @param id book��id
	 * @return ���� BookBean
	 */
	public BookBean selectBook(int id);
	
	/**
	 * ɾ��ָ�� id ������
	 * @param id book��id
	 */
	public void delBook(int id);
	
	/**
	 * ���ָ�������ݵ����ݿ�
	 * @param BookBean ��ӵ�����
	 */
	public void addBook(BookBean bookBean);
}
