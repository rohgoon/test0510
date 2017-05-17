package kr.or.dgit.bigdata.dto;

import java.text.DecimalFormat;

public class Department {
	private int dcode;
	private String dname;
	private int floor;
	public Department() {
		super();
	}
	public Department(int dcode, String dname, int floor) {
		super();
		this.dcode = dcode;
		this.dname = dname;
		this.floor = floor;
	}
	public int getDcode() {
		return dcode;
	}
	public void setDcode(int dcode) {
		this.dcode = dcode;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	public String[] toArray(){
		DecimalFormat df = new DecimalFormat("D000");
		String[] resArr = {df.format(dcode), dname, floor+""};
		return resArr;
	}
	@Override
	public String toString() {
		return String.format("Department [dcode=%s, dname=%s, floor=%s]", dcode, dname, floor);
	}
	
}
