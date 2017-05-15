package kr.or.dgit.bigdata.mappers;

import java.util.List;

import kr.or.dgit.bigdata.dto.Employee;

public interface EmployeeMapper {
	public void insert(Employee dto);
	public void update(Employee dto);
	public void delete(int dno);
	public List<Employee> selectAll();
	public Employee selectOne(int dno);
	public Employee selectLastOne();
}
