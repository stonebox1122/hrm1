package com.stone.hrm.service;

import com.stone.hrm.dao.PermissionDao;
import com.stone.hrm.pojo.Permission;
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
 * permission服务层
 * 
 * @author Administrator
 *
 */
@Service
public class PermissionService {

	@Autowired
	private PermissionDao permissionDao;
	
//	@Autowired
//	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Permission> findAll() {
		return permissionDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Permission> findSearch(Map whereMap, int page, int size) {
		Specification<Permission> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return permissionDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Permission> findSearch(Map whereMap) {
		Specification<Permission> specification = createSpecification(whereMap);
		return permissionDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Permission findById(Integer id) {
		return permissionDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param permission
	 */
	public void add(Permission permission) {
		// permission.setId( idWorker.nextId()+"" ); 雪花分布式ID生成器
		permissionDao.save(permission);
	}

	/**
	 * 修改
	 * @param permission
	 */
	public void update(Permission permission) {
		permissionDao.save(permission);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(Integer id) {
		permissionDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Permission> createSpecification(Map searchMap) {

		return new Specification<Permission>() {

			@Override
			public Predicate toPredicate(Root<Permission> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 权限名称
                if (searchMap.get("name")!=null && !"".equals(searchMap.get("name"))) {
                	predicateList.add(cb.like(root.get("name").as(String.class), "%"+(String)searchMap.get("name")+"%"));
                }
                // 权限描述
                if (searchMap.get("description")!=null && !"".equals(searchMap.get("description"))) {
                	predicateList.add(cb.like(root.get("description").as(String.class), "%"+(String)searchMap.get("description")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
