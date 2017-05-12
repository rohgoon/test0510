package kr.or.dgit.bigdata.service;

import java.util.List;

import org.apache.log4j.Logger;

import kr.or.dgit.bigdata.dto.EmployeeDto;

public class EmployeeService extends AbstractService<EmployeeDto,EmployeeService>{
	private static final Logger logger = Logger.getLogger(EmployeeService.class);
	/*private static final EmployeeService instance = new EmployeeService();
	public static EmployeeService getInstance() {
		return instance;
	}*/
	@Override
	public void insert(EmployeeDto dto) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(EmployeeDto dto) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(int no) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<EmployeeDto> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public EmployeeDto selectOne(int no) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
