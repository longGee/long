package org.lanqiao.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.lanqiao.entity.Dept;
import org.lanqiao.entity.Emp;
import org.lanqiao.entity.EmpVo;
import org.lanqiao.mapper.EmpMapper;

public class EmpMapperTest {
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
		EmpMapper mapper = session.getMapper(EmpMapper.class);
		EmpVo emp = mapper.get(7369);
		session.close();
		System.out.println(emp);
	}
	
	@Test
	public void testGetEmpById(){
		SqlSession session = factory.openSession();
		EmpMapper mapper = session.getMapper(EmpMapper.class);
		Emp emp = mapper.getEmpByID(7369);
		session.close();
		System.out.println(emp.toString());
	}
	
	@Test
	public void testGet_Two(){
		SqlSession session = factory.openSession();
		EmpMapper mapper = session.getMapper(EmpMapper.class);
		Emp emp = mapper.getEmpByID(7369);
		session.close();
		System.out.println(emp.toString());
	}
	
	//=================================================================
	//动态Sql
	@Test
	public void testSearch(){
		SqlSession session = factory.openSession();
		EmpMapper mapper = session.getMapper(EmpMapper.class);
		//方式1
		/*EmpVo empVo = null;*/
		//方式2
		EmpVo empVo = new EmpVo();
		Dept dept = new Dept();
		dept.setDeptno(20);
		empVo.setDept(dept);
		empVo.setSal(1000.0);
		empVo.setJob("MANAGER");
		List<Emp> listEmp = mapper.search(empVo);
		session.close();
		System.out.println(listEmp.toString());
	}
	
	@Test
	public void testGetList(){
		SqlSession session = factory.openSession();
		EmpMapper mapper = session.getMapper(EmpMapper.class);
		List<Integer> list = new ArrayList<Integer>();
		list.add(7369);
		list.add(7876);
		List<Emp> emps = mapper.getList(list);
		session.close();
		System.out.println(emps);
	}
	
	//测试一级缓存
	@Test
	public void testCache(){
		//测试一级缓存
		/*SqlSession session = factory.openSession();
		EmpMapper mapper = session.getMapper(EmpMapper.class);*/
		/*Emp emp = mapper.get(7369);
		System.out.println("=======================================");
		//在同一个session中找同一个对象，就不会从数据库中找，而是从缓存中找（不会产生数据库查询语句）
		Emp emp2 = mapper.get(7369);
		session.close();
		System.out.println(emp2);*/
		
		//测试二级缓存
		SqlSession session = factory.openSession();
		EmpMapper mapper = session.getMapper(EmpMapper.class);
		Emp emp = mapper.get(7369);
		System.out.println(emp);
		//清除一、二级的缓存
		session.clearCache();
//		session.close();
		System.out.println("===========================测试二级缓存");
		SqlSession session2 = factory.openSession();
		EmpMapper mapper2 = session2.getMapper(EmpMapper.class);
		Emp emp2 = mapper2.get(7369);
		System.out.println(emp2);
		session2.close();
		System.out.println("===========================测试二级缓存");
		SqlSession session3 = factory.openSession();
		EmpMapper mapper3 = session3.getMapper(EmpMapper.class);
		Emp emp3 = mapper3.get(7369);
		System.out.println(emp3);
		session3.close();
		System.out.println("===========================测试二级缓存");
		
	}
	
}
