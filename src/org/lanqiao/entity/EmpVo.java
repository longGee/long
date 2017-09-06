package org.lanqiao.entity;
//empvo:包装类
public class EmpVo extends Emp {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dname;
	private String loc;
	
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
