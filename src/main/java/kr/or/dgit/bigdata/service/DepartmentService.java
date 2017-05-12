package kr.or.dgit.bigdata.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import kr.or.dgit.bigdata.dto.DepartmentDto;
import kr.or.dgit.bigdata.mappers.DepartmentMapper;
import kr.or.dgit.bigdata.util.MyBatisSqlSessionFactory;

public class DepartmentService extends AbstractService<DepartmentDto,DepartmentService>{
	private static final Logger logger = Logger.getLogger(DepartmentService.class);
	/*private static final DepartmentService instance = new DepartmentService();
	public static DepartmentService getInstance() {
		return instance;
	}*/
	public DepartmentService() {}
	@Override
	public void insert(DepartmentDto dto) {
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
	public void update(DepartmentDto dto) {
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
	public List<DepartmentDto> selectAll() {
		if (logger.isDebugEnabled()) {
			logger.debug("selectAll() - start");
		}
		List<DepartmentDto> dto = new ArrayList<DepartmentDto>();
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
	public DepartmentDto selectOne(int no) {
		if (logger.isDebugEnabled()) {
			logger.debug("selectAll() - start");
		}
		DepartmentDto dto = new DepartmentDto();
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
