package com.tuyano.springboot.page;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tuyano.springboot.UserBean;

@Repository
public interface PageRepository extends JpaRepository<UserBean, Long>{
	public Page<UserBean> findAll(Pageable pageable);
}
