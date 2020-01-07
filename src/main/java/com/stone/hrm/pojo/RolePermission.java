package com.stone.hrm.pojo;

import javax.persistence.*;
import java.io.Serializable;
/**
 * rolePermission实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_role_permission")
public class RolePermission implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;//ID


	
	private Integer roleId;//角色ID
	private Integer permissionId;//权限ID
	private java.util.Date createTime;//创建时间

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}


	
}
