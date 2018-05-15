package com.tuyano.springboot;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class CriteriaSampleDAO implements DaoBase<UserBean>{
	private EntityManager manager;

	public CriteriaSampleDAO() {
		super();
	}
	public CriteriaSampleDAO(EntityManager manager) {
		this();
		this.manager = manager;
	}

	@Override
	public List<UserBean> getAll() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<UserBean> query = builder.createQuery(UserBean.class);
		Root<UserBean> root = query.from(UserBean.class);
		query.select(root);

		return manager.createQuery(query).getResultList();
	}

	public List<UserBean> nameSerch(String name) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<UserBean> query = builder.createQuery(UserBean.class);
		Root<UserBean> root = query.from(UserBean.class);
		query.select(root)
			.where(builder.like(root.get("name"), "%" + name + "%"));

		return manager.createQuery(query).getResultList();
	}

	public List<UserBean> orderByDesc(){
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<UserBean> query = builder.createQuery(UserBean.class);
		Root<UserBean> root = query.from(UserBean.class);
		query.select(root)
			.orderBy(builder.desc(root.get("id")));
		return manager.createQuery(query).getResultList();
	}

	public List<UserBean> limit(int first, int count){
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<UserBean> query = builder.createQuery(UserBean.class);
		Root<UserBean> root = query.from(UserBean.class);
		query.select(root);
		List<UserBean> list = manager.createQuery(query)
				.setFirstResult(first)
				.setMaxResults(count)
				.getResultList();

		return list;
	}
}
