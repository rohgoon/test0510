package kr.or.dgit.bigdata.mappers;

import java.util.List;

import kr.or.dgit.bigdata.dto.DepartmentDto;

public interface DepartmentMapper{
	public void insert(DepartmentDto dto);
	public void update(DepartmentDto dto);
	public void delete(int dno);
	public List<DepartmentDto> selectAll();
	public DepartmentDto selectOne(int dno);
}
