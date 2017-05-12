package kr.or.dgit.bigdata.mappers;

import java.util.List;

import kr.or.dgit.bigdata.dto.EmployeeDto;

public interface EmployeeMapper {
	public void insert(EmployeeDto dto);
	public void update(EmployeeDto dto);
	public void delete(int dno);
	public List<EmployeeDto> selectAll();
	public EmployeeDto selectOne(int dno);
}
