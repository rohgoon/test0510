package kr.or.dgit.bigdata.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import kr.or.dgit.bigdata.dto.Department;
import kr.or.dgit.bigdata.mappers.DepartmentMapper;
import kr.or.dgit.bigdata.util.MyBatisSqlSessionFactory;

public class DepartmentService{
	private static final Logger logger = Logger.getLogger(DepartmentService.class);
	private static final DepartmentService instance = new DepartmentService();
	public static DepartmentService getInstance() {
		return instance;
	}
	public DepartmentService() {}
	
	public void insert(Department dto) {
		if (logger.isDebugEnabled()) {
			logger.debug("insert(DepartmentDto) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try{
			DepartmentMapper dMapper = sqlSession.getMapper(DepartmentMapper.class);
			dMapper.insert(dto);
			sqlSession.commit();
		}finally {
			sqlSession.close();
		}
	}
	
	public void update(Department dto) {
		if (logger.isDebugEnabled()) {
			logger.debug("update(DepartmentDto) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try{
			DepartmentMapper dMapper = sqlSession.getMapper(DepartmentMapper.class);
			dMapper.update(dto);
			sqlSession.commit();
		}finally {
			sqlSession.close();
		}
	}
	
	public void delete(int no) {
		if (logger.isDebugEnabled()) {
			logger.debug("delete(int) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try{
			DepartmentMapper dMapper = sqlSession.getMapper(DepartmentMapper.class);
			dMapper.delete(no);
			sqlSession.commit();
		}finally {
			sqlSession.close();
		}
	}
	
	public List<Department> selectAll() {
		if (logger.isDebugEnabled()) {
			logger.debug("selectAll() - start");
		}
		System.out.println("Department selectAll start");
		List<Department> dto = new ArrayList<Department>();
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try{
			System.out.println("Department selectAll sqlSession open");
			DepartmentMapper dMapper = sqlSession.getMapper(DepartmentMapper.class);
			System.out.println(sqlSession.toString());
			dto = dMapper.selectAll();			
			//System.out.println(dto.get(0).toString());
			System.out.println("Department selectAll end");
		}finally {
			sqlSession.close();
		}
		
		return dto;
	}
	
	public Department selectOne(int no) {
		if (logger.isDebugEnabled()) {
			logger.debug("selectOne() - start");
		}
		Department dto = new Department();
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try{
			DepartmentMapper dMapper = sqlSession.getMapper(DepartmentMapper.class);
			dto = dMapper.selectOne(no);
		}finally {
			sqlSession.close();
		}
		
		return dto;
	}
}
