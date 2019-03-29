package com.syc.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

public class PlayHqy {
	/**
	 * @author XPS13
	 * @data 2019-3-26 15:45
	 * @detail ʵ��mybatis���ݿ����Ӳ���
	 */
	@Test
	public  void getSession() {
		Logger log=Logger.getLogger(PlayHqy.class);
		SqlSessionFactory sf = null;
		SqlSession ss = null;
		// �����ַ��������,����sessionFactory��
		try {
			Reader rd = Resources.getResourceAsReader("my.xml");
			// ����һ��sessionFactory��ʵ����Ķ���
			sf = new SqlSessionFactoryBuilder().build(rd);
			// �������ݿ��������
			ss = sf.openSession();
			//log.info("���ӳɹ�");
			System.out.println("---ok-----");
		} catch (IOException e) {
			log.error("oh,my god");
			e.printStackTrace();
		}
		//return ss;
	}

	// �ر����ݿ��������
	public static void closeDB(SqlSession ss) {
		if (ss != null) {
			ss.close();
		}
	}

}
