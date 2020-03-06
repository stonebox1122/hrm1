package com.stone.hrm.pojo;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * department实体类
 * @author sl
 *
 */
@Table(name="tb_department")
public class Department implements Serializable {

	@Id
	@KeySql(useGeneratedKeys = true)
	private Integer id;//ID


	
	private String name;//部门名称
	private String code;//部门编码
	private String organizationCode;//组织编码
	private String pcode;//父级部门编码
	@Column(insertable = false)
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

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getOrganizationCode() {
		return organizationCode;
	}
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
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
