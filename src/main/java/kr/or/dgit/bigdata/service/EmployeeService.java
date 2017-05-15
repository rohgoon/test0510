package kr.or.dgit.bigdata.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import kr.or.dgit.bigdata.dto.Employee;
import kr.or.dgit.bigdata.mappers.EmployeeMapper;
import kr.or.dgit.bigdata.util.MyBatisSqlSessionFactory;

public class EmployeeService extends AbstractService<Employee>{
	private static final Logger logger = Logger.getLogger(EmployeeService.class);
	private static final EmployeeService instance = new EmployeeService();
	public static EmployeeService getInstance() {
		return instance;
	}
	@Override
	public void insert(Employee dto) {
		if (logger.isDebugEnabled()) {
			logger.debug("insert(EmployeeDto) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try{
			EmployeeMapper dMapper = sqlSession.getMapper(EmployeeMapper.class);
			dMapper.insert(dto);
			sqlSession.commit();
		}finally {
			sqlSession.close();
		}
	}
	@Override
	public void update(Employee dto) {
		if (logger.isDebugEnabled()) {
			logger.debug("update(DepartmentDto) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try{
			EmployeeMapper dMapper = sqlSession.getMapper(EmployeeMapper.class);
			dMapper.update(dto);
			sqlSession.commit();
		}finally {
			sqlSession.close();
		}
	}
	@Override
	public void delete(int no) {
		if (logger.isDebugEnabled()) {
			logger.debug("delete(int) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try{
			EmployeeMapper dMapper = sqlSession.getMapper(EmployeeMapper.class);
			dMapper.delete(no);
			sqlSession.commit();
		}finally {
			sqlSession.close();
		}
	}
	@Override
	public List<Employee> selectAll() {
		if (logger.isDebugEnabled()) {
			logger.debug("selectAll() - start");
		}
		List<Employee> dto = new ArrayList<Employee>();
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try{
			EmployeeMapper dMapper = sqlSession.getMapper(EmployeeMapper.class);
			dto = dMapper.selectAll();
		}finally {
			sqlSession.close();
		}
		
		return dto;
	}
	@Override
	public Employee selectOne(int no) {
		if (logger.isDebugEnabled()) {
			logger.debug("selectOne() - start");
		}
		Employee dto = new Employee();
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try{
			EmployeeMapper dMapper = sqlSession.getMapper(EmployeeMapper.class);
			dto = dMapper.selectOne(no);
		}finally {
			sqlSession.close();
		}
		
		return dto;
	}
	@Override
	public Employee selectLastOne() {
		if (logger.isDebugEnabled()) {
			logger.debug("selectLastOne() - start");
		}
		Employee dto = new Employee();
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try{
			EmployeeMapper dMapper = sqlSession.getMapper(EmployeeMapper.class);
			dto = dMapper.selectLastOne();
		}finally {
			sqlSession.close();
		}
		
		return dto;
	}
	
}
