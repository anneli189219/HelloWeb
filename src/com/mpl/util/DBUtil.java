package com.mpl.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * 数据库操作池工具类
 * 
 * @author mopeiwen
 * @version 2019年10月10日 下午2:46:09
 */
public class DBUtil{
	// 声明一个DataSource对象
	private static DataSource ds = null;

	// 类加载只执行一次
	static {
		try {
			// 加载配置文件并读取
			Properties p = new Properties();
			FileInputStream in = new FileInputStream("resource/dbcp.properties");
			p.load(in);
			ds = BasicDataSourceFactory.createDataSource(p);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	/*
	 * 获取连接对象方法
	 */
	public static Connection getConnection() {

		Connection conn;
		try {
			conn = ds.getConnection();
			return conn;
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}

	}

	public static void close(Connection conn) {
		try {
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static void close(PreparedStatement ps) {
		try {
			ps.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
