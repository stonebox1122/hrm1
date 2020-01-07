package com.stone.hrm.pojo;

import javax.persistence.*;
import java.io.Serializable;
/**
 * userRole实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_user_role")
public class UserRole implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;//ID


	
	private Integer userId;//用户ID
	private Integer roleId;//角色ID
	private java.util.Date createTime;//创建时间

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}


	
}
