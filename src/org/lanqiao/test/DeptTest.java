package org.lanqiao.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.lanqiao.entity.Dept;
import org.lanqiao.mapper.DeptMapper;

public class DeptTest {
	private static SqlSessionFactory factory;
	static{
		String resource = "mybatis-conf.xml";
		InputStream in;
		try {
			in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);//SqlSessionFactoryBuilder这个对象是临时的，创建完就没了，所以不要定义成全局变量
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGet(){
		SqlSession session = factory.openSession();
		DeptMapper mapper = session.getMapper(DeptMapper.class);
		Dept dept = mapper.get(10);
		System.out.println(dept.toString());
	}
}
