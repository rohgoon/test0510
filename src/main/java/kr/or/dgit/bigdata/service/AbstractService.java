package kr.or.dgit.bigdata.service;

import java.util.List;

public abstract class AbstractService<T,S> {
	public Class<S> instance;
	public Class<S> getInstance() {
		return this.instance;
	}
	public abstract void insert(T dto);
	public abstract void update(T dto);
	public abstract void delete(int no);
	public abstract List<T> selectAll();
	public abstract T selectOne(int no);
}
