package org.lanqiao.entity;

import java.util.List;

public class Dept {
	private Integer deptno;
	private String dname;
	private String loc;
	private List<Emp> emps;
	//构成双向联系的时候两个实体类中只能有一个ToString方法
	//不然会重复调用ToString方法导致跑出内存溢出异常
	
	public List<Emp> getEmps() {
		return emps;
	}
	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}
	/*@Override
	public String toString() {//多对多
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc
				+ "]";
	}*/
	
	
	public Dept() {
		super();
	}
	/*@Override
	public String toString() {//一对多
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc
				+ ", emps=" + emps + "]";
	}*/
	//多对多
	public Dept(Integer deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
}
