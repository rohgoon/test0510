package kr.or.dgit.bigdata.dto;

import java.util.Date;

public class EmployeeDto {
	private int eno;
	private String ename;
	private int salary;
	private int dno;
	private boolean gender;
	private Date joindate;
	private int title;
	public EmployeeDto() {
		super();
	}
	public EmployeeDto(int eno, String ename, int salary, int dno, boolean gender, Date joindate, int title) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.salary = salary;
		this.dno = dno;
		this.gender = gender;
		this.joindate = joindate;
		this.title = title;
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	public int getTitle() {
		return title;
	}
	public void setTitle(int title) {
		this.title = title;
	}
	
}
