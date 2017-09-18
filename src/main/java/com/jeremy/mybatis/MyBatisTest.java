/**
 * 
 */
package com.jeremy.mybatis;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.jeremy.mybatis.model.JobStatusTraceLog;

/**
 * @author jeremy
 *
 */
public class MyBatisTest {

	public static void main(String[] args) {
		InputStream in = MyBatisTest.class.getClassLoader().getResourceAsStream("sql/mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = sqlSessionFactory.openSession();
		JobStatusTraceLog log = session.selectOne("com.jeremy.mybatis.dao.JobStatusTraceLogDao.selectById", "0cd1c127-9774-46b4-936a-28502cbb6cbd");
		session.delete("");
		System.out.println(log);
		
	}
}
