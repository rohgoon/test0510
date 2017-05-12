package kr.or.dgit.bigdata.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import kr.or.dgit.bigdata.dto.Department;
import kr.or.dgit.bigdata.mappers.DepartmentMapper;
import kr.or.dgit.bigdata.util.MyBatisSqlSessionFactory;

public class DepartmentService extends AbstractService<Department>{
	private static final Logger logger = Logger.getLogger(DepartmentService.class);
	private static final DepartmentService instance = new DepartmentService();
	public static DepartmentService getInstance() {
		return instance;
	}
	public DepartmentService() {}
	@Override
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
	@Override
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
	@Override
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
	@Override
	public List<Department> selectAll() {
		if (logger.isDebugEnabled()) {
			logger.debug("selectAll() - start");
		}
		List<Department> dto = new ArrayList<Department>();
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try{
			DepartmentMapper dMapper = sqlSession.getMapper(DepartmentMapper.class);
			dto = dMapper.selectAll();
		}finally {
			sqlSession.close();
		}
		
		return dto;
	}
	@Override
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
