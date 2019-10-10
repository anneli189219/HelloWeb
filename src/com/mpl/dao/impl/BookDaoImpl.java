package com.mpl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mpl.dao.BookDao;
import com.mpl.entity.BookBean;
import com.mpl.util.DBUtil;

/**
 * dao层实现类
 * @author 17软工莫培文
 *
 */
public class BookDaoImpl implements BookDao {

	@Override
	public BookBean selectBook(int id) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt;
		BookBean bookBean = new BookBean();
		try {
			pstmt = conn.prepareStatement("select * from book where id = ?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bookBean.setId(rs.getInt("id"));
				bookBean.setBookName(rs.getString("bookName"));
				bookBean.setPrice(rs.getInt("price"));
				bookBean.setDescription(rs.getString("description"));

				//System.out.println(bookBean);
				return bookBean;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void delBook(int id) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement("delete from book where id=?");
			pstmt.setInt(1, id);
			int rs = pstmt.executeUpdate();
			//System.out.println(rs);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void addBook(BookBean bookBean) {
		Connection conn = DBUtil.getConnection();// 创建连接
		PreparedStatement pstmt;// 创建声明sql入口
		try {
			pstmt = conn.prepareStatement("insert into book(id,bookName,price,description) values(?,?,?,?)");
			pstmt.setInt(1, bookBean.getId());
			pstmt.setString(2, bookBean.getBookName());
			pstmt.setInt(3, bookBean.getPrice());
			pstmt.setString(4, bookBean.getDescription());
			int rs = pstmt.executeUpdate();// 提交sql语句并得到提交结果
			//System.out.println(rs);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void updateBook(BookBean bookBean) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement("update book set bookName=?,price=?,description=? where id=?");
			pstmt.setString(1, bookBean.getBookName());
			pstmt.setInt(2, bookBean.getPrice());
			pstmt.setString(3, bookBean.getDescription());
			pstmt.setInt(4, bookBean.getId());
			int rs = pstmt.executeUpdate();
			//System.out.println(rs);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<BookBean> selectBooks() {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt;
		BookBean bookBean = new BookBean();
		ArrayList<BookBean> books  = new ArrayList<BookBean>();
		try {
			pstmt = conn.prepareStatement("select * from book");
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				bookBean = new BookBean();
				bookBean.setId(rs.getInt("id"));
				bookBean.setBookName(rs.getString("bookName"));
				bookBean.setPrice(rs.getInt("price"));
				bookBean.setDescription(rs.getString("description"));
				
				//System.out.println(bookBean);
				
				books.add(bookBean);
				
			}
			return books;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	@Override
	public BookBean selectBook(String bookName) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt;
		BookBean bookBean = new BookBean();
		try {
			pstmt = conn.prepareStatement("select * from book where bookName like ?");
			pstmt.setString(1, "%"+bookName+"%");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bookBean.setId(rs.getInt("id"));
				bookBean.setBookName(rs.getString("bookName"));
				bookBean.setPrice(rs.getInt("price"));
				bookBean.setDescription(rs.getString("description"));

				//System.out.println(bookBean);
				return bookBean;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

}
