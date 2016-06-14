package cn.test.dao;

public interface BaseDAO<T> {
	// 添加
	public void add(T t);

	// 查询
	public T get(T t);

	// 删除
	public void delete(T t);

	// 更新
	public void update(T t);

}
