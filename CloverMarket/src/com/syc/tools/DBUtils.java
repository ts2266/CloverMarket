package com.syc.tools;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class DBUtils {
	/**
	 * @author XPS13
	 * @data 2019-3-26 15:45
	 * @detail 实现mybatis数据库连接操作
	 */
	public static SqlSession getSession() {
		Logger log=Logger.getLogger(DBUtils.class);
		SqlSessionFactory sf = null;
		SqlSession ss = null;
		// 生成字符输入对象,传入sessionFactory中
		try {
			Reader rd = Resources.getResourceAsReader("my.xml");
			// 创建一个sessionFactory的实现类的对象
			sf = new SqlSessionFactoryBuilder().build(rd);
			// 生成数据库操作对象
			ss = sf.openSession();
			log.info("连接成功");
			//System.out.println("--------");
		} catch (IOException e) {
			log.error("oh,my god");
			e.printStackTrace();
		}
		return ss;
	}

	// 关闭数据库操作对象
	public static void closeDB(SqlSession ss) {
		if (ss != null) {
			ss.close();
		}
	}

}
