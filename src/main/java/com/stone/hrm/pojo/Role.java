package com.stone.hrm.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * role实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_role")
public class Role implements Serializable, GrantedAuthority {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;//ID


	
	private String name;//角色名称
	private String description;//角色描述
	private Integer status;//状态：0为禁用，1为启用
	private java.util.Date createTime;//创建时间
	@ManyToMany(mappedBy = "roles")
	private List<User> users;

	
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


	@JsonIgnore
	@Override
	public String getAuthority() {
		return name;
	}
}
