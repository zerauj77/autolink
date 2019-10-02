package com.autolink.interfaces;

import java.util.List;

public interface AbstractIF {
	
	public boolean save(final Object obj);
	public List findAll(final Class clazz);
	public List findByWhereStatement(final Class clazz, final String whereStatement);
	public List findValuesByWhereStatement(final Class clazz, final String values, final String whereStatement);
	public List executeHQLStatement(final String HQLstatement);
	public List executeNamedQuery(final String name);
	public List executeNamedQuery(final String name, final Object[] parameters);
	public List executeNamedQuery(final String name, final String[] paramNames, final Object[] parameters);
	public Object findUniqueResult(final Class clazz, final String whereStatement);
	public Object findFirstRow(final Class clazz, final String whereStatement);
	public void refreshObjects(final List objects);
	public void refreshObject(final Object object);
	public void delete(Object obj);
	public boolean update(Object obj);
	public List findAllOrderBy(Class clazz, int start, int limit, String orderBy);


}
