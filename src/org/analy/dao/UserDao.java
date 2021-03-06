package org.analy.dao;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.analy.bean.User;
import org.analy.pool.MysqlPool;
import org.apache.log4j.Logger;


public class UserDao {
	static ArrayList<User> users = new ArrayList<User>();
	static Logger logger =  Logger.getLogger(UserDao.class);

	public static void main(String[] args) {
	
	}
	/*
	 * 分析用户位置分布
	 * */
	public void groupByUserForArea(){
		
	}
	/*
	 * 分析用户年龄
	 * */
	public void groupByUserForAge(){
		
	}
	/*
	 * 分析用户性别
	 * */
	public void groupByUserForGender() throws SQLException{
		Connection conn = MysqlPool.pool.getConnection();
		String sql = "Select gender,count(*) as num from user goup by gender";
		PreparedStatement ps;
		ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
	}

	public void addUsers(User user) { 
		// users.add(_user);
		// if (users.size() > 10) {
		Connection conn = MysqlPool.pool.getConnection();
		String sql = "replace into user(username,weibo_id,gender,age,area,fans_num,follow_num,feed_num,record,avatar,level,uid,sign,province,city) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			// for (User user : users) {
			ps.setString(1, user.getUsername());
			ps.setLong(2, user.getWeibo_id());
			ps.setInt(3, user.getGender());
			ps.setInt(4, user.getAge());
			ps.setString(5, user.getArea());
			ps.setLong(6, user.getFans_num());
			ps.setInt(7, user.getFollow_num());
			ps.setInt(8, user.getFeed_num());
			ps.setLong(9, user.getRecord());
			ps.setString(10, user.getAvatar());
			ps.setInt(11, user.getLevel());
			ps.setLong(12, user.getUid());
			ps.setString(13, user.getSign());
			ps.setInt(14, user.getProvince());
			ps.setInt(15, user.getCity());
			ps.addBatch();
			ps.executeBatch();
			ps.close();
			// }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			MysqlPool.pool.returnConnection(conn);
			// ps.executeUpdate();无法判断是否已经插入
			// users.clear();
			System.out.println("插入失败 from:" + user);
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			System.out.println(sw.toString());
			
			
			
		} finally {
			MysqlPool.pool.returnConnection(conn);
			// MysqlPool.pool.returnConnection(conn);
		}

		// }else{

		// }
	}
}
