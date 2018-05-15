package com.tuyano.springboot;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class SampleDAO implements DaoBase<UserBean>{
	private EntityManager manager;

	public SampleDAO() {
		super();
	}
	public SampleDAO(EntityManager manager) {
		this();
		this.manager = manager;
	}

	@Override
	public List<UserBean> getAll() {
		// select * from tbl_sample
		Query query = manager.createQuery("from UserBean");
		List<UserBean> list = query.getResultList();
		manager.close();
		return list;
	}

	public List<UserBean> selectByPK(long id) {
		return manager.createQuery("from UserBean where id = " + id).getResultList();
	}

	public List<UserBean> selectByPkUseBind(long id) {
		String qstr = "from UserBean where id = :id";
		Query query = manager.createQuery(qstr)
				.setParameter("id", id);
		return query.getResultList();
	}

	public List<UserBean> namedQuery(long id){
		Query query = manager.createNamedQuery("findById")
				.setParameter("id", id);
		return query.getResultList();
	}
}
