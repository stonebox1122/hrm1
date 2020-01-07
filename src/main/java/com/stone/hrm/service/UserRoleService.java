package com.stone.hrm.service;

import com.stone.hrm.dao.UserRoleDao;
import com.stone.hrm.pojo.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * userRole服务层
 * 
 * @author Administrator
 *
 */
@Service
public class UserRoleService {

	@Autowired
	private UserRoleDao userRoleDao;
	
//	@Autowired
//	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<UserRole> findAll() {
		return userRoleDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<UserRole> findSearch(Map whereMap, int page, int size) {
		Specification<UserRole> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return userRoleDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<UserRole> findSearch(Map whereMap) {
		Specification<UserRole> specification = createSpecification(whereMap);
		return userRoleDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public UserRole findById(Integer id) {
		return userRoleDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param userRole
	 */
	public void add(UserRole userRole) {
		// userRole.setId( idWorker.nextId()+"" ); 雪花分布式ID生成器
		userRoleDao.save(userRole);
	}

	/**
	 * 修改
	 * @param userRole
	 */
	public void update(UserRole userRole) {
		userRoleDao.save(userRole);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(Integer id) {
		userRoleDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<UserRole> createSpecification(Map searchMap) {

		return new Specification<UserRole>() {

			@Override
			public Predicate toPredicate(Root<UserRole> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
