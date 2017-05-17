package kr.or.dgit.bigdata.dto;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import kr.or.dgit.bigdata.service.DepartmentService;
import kr.or.dgit.bigdata.service.TitleService;

public class Employee {
	private int eno;
	private String ename;
	private int salary;
	private int dno;
	private boolean gender;
	private Date joindate;
	private int title;
	public Employee() {
		super();
	}
	public Employee(int eno, String ename, int salary, int dno, boolean gender, Date joindate, int title) {
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
	public String[] toArray(){
		String g= "남";
		if (gender) {
			g="여";
		} 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String jd = sdf.format(joindate);
		Department department = DepartmentService.getInstance().selectOne(dno);
		Title t = TitleService.getInstance().selectOne(title);
		DecimalFormat df = new DecimalFormat("000");
		return new String[]{"E017"+df.format(eno), ename,t.getTname(),salary+"",g,department.getDname(),jd};
	}
	@Override
	public String toString() {
		return String.format("Employee [eno=%s, ename=%s, salary=%s, dno=%s, gender=%s, joindate=%s, title=%s]", eno,
				ename, salary, dno, gender, joindate, title);
	}
	
}
