package com.stone.hrm.pojo;

import javax.persistence.*;
import java.io.Serializable;
/**
 * role实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_role")
public class Role implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;//ID


	
	private String name;//角色名称
	private String description;//角色描述
	private Integer status;//状态：0为禁用，1为启用
	private java.util.Date createTime;//创建时间

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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


	
}
