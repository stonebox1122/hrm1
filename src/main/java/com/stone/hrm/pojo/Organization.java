package com.stone.hrm.pojo;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * organization实体类
 * @author sl
 *
 */
@Table(name="tb_organization")
public class Organization implements Serializable {

	@Id
	@KeySql(useGeneratedKeys = true)
	private Integer id;//ID


	
	private Integer pid;//父级ID
	private String name;//组织名称
	private String code;//组织代码
	private String address;//组织地址
	private String legalRepresentative;//法人代表
	private String phone;//组织电话
	private String mail;//组织邮箱
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

	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
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

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getLegalRepresentative() {
		return legalRepresentative;
	}
	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
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
