package kr.or.dgit.bigdata.mappers;

import java.util.List;

import kr.or.dgit.bigdata.dto.Department;

public interface DepartmentMapper{
	public void insert(Department dto);
	public void update(Department dto);
	public void delete(int dno);
	public List<Department> selectAll();
	public Department selectOne(int dno);
}
