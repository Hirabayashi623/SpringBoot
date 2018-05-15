package com.tuyano.springboot;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

@Service
public class SampleDataService {
	@PersistenceContext
	private EntityManager manager;

	public List<UserBean> getAll(){
		return (List<UserBean>) manager.createQuery("from UserBean").getResultList();
	}

//	public List<UserXmlBean> getXml(){
//		return (List<UserXmlBean>) manager.createQuery("from UserXmlBean").getResultList();
//	}
}
