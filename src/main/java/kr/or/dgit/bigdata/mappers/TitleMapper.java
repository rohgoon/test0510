package kr.or.dgit.bigdata.mappers;

import java.util.List;

import kr.or.dgit.bigdata.dto.TitleDto;

public interface TitleMapper {
	public void insert(TitleDto dto);
	public void update(TitleDto dto);
	public void delete(int dno);
	public List<TitleDto> selectAll();
	public TitleDto selectOne(int dno);
}
