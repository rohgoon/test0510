package kr.or.dgit.bigdata.mappers;

import java.util.List;

import kr.or.dgit.bigdata.dto.Title;

public interface TitleMapper {
	public void insert(Title dto);
	public void update(Title dto);
	public void delete(int dno);
	public List<Title> selectAll();
	public Title selectOne(int dno);
	public Title selectLastOne();
}
