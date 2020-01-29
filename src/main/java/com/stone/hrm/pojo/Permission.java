package com.stone.hrm.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name="tb_permission")
public class Permission implements Serializable {

	@Id
	private Integer id;//权限ID
	private Integer parentId;//父权限ID
	private String name;//权限名称
	private String css;//CSS样式
	private String path;//访问路径
	private Integer type;//权限类型 1为菜单 2为功能 3为API
	private String permission;//具体权限
	private Integer sort;//排序值
	private Integer status;//状态：0为禁用，1为启用
	@Column(insertable = false, updatable = false)
	private java.util.Date createTime;//创建时间
	@Column(insertable = false)
	private java.util.Date updateTime;//更新时间

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCss() {
		return css;
	}
	public void setCss(String css) {
		this.css = css;
	}

	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}

	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public java.util.Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}



}
