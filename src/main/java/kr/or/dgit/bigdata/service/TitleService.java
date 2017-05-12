package kr.or.dgit.bigdata.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import kr.or.dgit.bigdata.dto.TitleDto;
import kr.or.dgit.bigdata.mappers.TitleMapper;
import kr.or.dgit.bigdata.util.MyBatisSqlSessionFactory;

public class TitleService extends AbstractService<TitleDto>{
	private static final Logger logger = Logger.getLogger(TitleService.class);
	private static final TitleService instance = new TitleService();
	public static TitleService getInstance() {
		return instance;
	}
	@Override
	public void insert(TitleDto dto) {
		if (logger.isDebugEnabled()) {
			logger.debug("update(TitleDto) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try{
			TitleMapper tMapper = sqlSession.getMapper(TitleMapper.class);
			tMapper.insert(dto);
			sqlSession.commit();
		}finally {
			sqlSession.close();
		}
	}
	@Override
	public void update(TitleDto dto) {
		if (logger.isDebugEnabled()) {
			logger.debug("update(TitleDto) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try{
			TitleMapper tMapper = sqlSession.getMapper(TitleMapper.class);
			tMapper.update(dto);
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
			TitleMapper tMapper = sqlSession.getMapper(TitleMapper.class);
			tMapper.delete(no);
			sqlSession.commit();
		}finally {
			sqlSession.close();
		}
	}
	@Override
	public List<TitleDto> selectAll() {
		if (logger.isDebugEnabled()) {
			logger.debug("selectAll() - start");
		}
		List<TitleDto> dto = new ArrayList<TitleDto>();
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try{
			TitleMapper tMapper = sqlSession.getMapper(TitleMapper.class);
			dto = tMapper.selectAll();
		}finally {
			sqlSession.close();
		}
		
		return dto;
	}
	@Override
	public TitleDto selectOne(int no) {
		if (logger.isDebugEnabled()) {
			logger.debug("selectOne() - start");
		}
		TitleDto dto = new TitleDto();
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try{
			TitleMapper tMapper = sqlSession.getMapper(TitleMapper.class);
			dto = tMapper.selectOne(no);
		}finally {
			sqlSession.close();
		}
		
		return dto;
	}
}
