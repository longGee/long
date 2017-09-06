package org.lanqiao.mapper;

import java.util.List;

import org.lanqiao.entity.Emp;
import org.lanqiao.entity.EmpVo;

public interface EmpMapper {
	public EmpVo get(Integer empno);
	public Emp getEmpByID(Integer empno);
	
	//动态SQL
	public List<Emp> search(EmpVo empvo);
	public List<Emp> getList(List<Integer> list);
}
