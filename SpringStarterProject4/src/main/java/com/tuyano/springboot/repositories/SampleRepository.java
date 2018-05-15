package com.tuyano.springboot.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tuyano.springboot.UserBean;


@Repository
public interface SampleRepository extends JpaRepository<UserBean, Long>{
	public Optional<UserBean> findById(long id);
	public List<UserBean> findByIdAndName(long id, String name);
	public List<UserBean> findByIdOrId(long id1, long id2);
	public List<UserBean> findByIdBetween(long id1, long id2);
	public List<UserBean> findByIdLessThan(long id);
	public List<UserBean> findByIdGreaterThan(long id);
	public List<UserBean> findByIdIsNull();
	public List<UserBean> findByIdNotNull();
	public List<UserBean> findByNameLike(String name);
	public List<UserBean> findByNameLikeOrderByIdDesc(String name);
	public List<UserBean> findByIdNot(long id);
	public List<UserBean> findByIdIn(List<Long> id);

	@Query("from UserBean where id > 5 order by id desc")
	public List<UserBean> query();

	@Query("from UserBean where id = :id")
	public List<UserBean> queryBind(@Param("id") long id);
}
