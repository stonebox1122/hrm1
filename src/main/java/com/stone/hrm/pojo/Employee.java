package com.stone.hrm.pojo;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * employee实体类
 * @author sl
 *
 */
@Table(name="tb_employee")
public class Employee implements Serializable {

	@Id
	@KeySql(useGeneratedKeys = true)
	private Integer id;//ID


	
	private String name;//员工姓名
	private String username;//员工工号
	private String password;//登录密码
	private String state;//在职状态
	private String managername;//领导工号
	private String sex;//性别
	private String phone;//手机
	private String mail;//邮箱
	private java.util.Date hiredate;//入职时间
	private java.util.Date birthday;//出生日期
	private String marriage;//婚姻状态：单身，已婚，离异，丧偶
	private String national;//国籍
	private String address;//地址
	private String education;//学历
	private String degree;//学位
	private String graduationSchool;//毕业院校
	private java.util.Date graduationDate;//毕业时间
	private String jobCode;//职位编码
	private String bankName;//银行名称
	private String bankNumber;//银行卡号
	private String politicalVisage;//政治面貌
	private String idCard;//身份证
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

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public String getManagername() {
		return managername;
	}
	public void setManagername(String managername) {
		this.managername = managername;
	}

	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
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

	public java.util.Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(java.util.Date hiredate) {
		this.hiredate = hiredate;
	}

	public java.util.Date getBirthday() {
		return birthday;
	}
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}

	public String getMarriage() {
		return marriage;
	}
	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getNational() {
		return national;
	}
	public void setNational(String national) {
		this.national = national;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}

	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getGraduationSchool() {
		return graduationSchool;
	}
	public void setGraduationSchool(String graduationSchool) {
		this.graduationSchool = graduationSchool;
	}

	public java.util.Date getGraduationDate() {
		return graduationDate;
	}
	public void setGraduationDate(java.util.Date graduationDate) {
		this.graduationDate = graduationDate;
	}

	public String getJobCode() {
		return jobCode;
	}
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankNumber() {
		return bankNumber;
	}
	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}

	public String getPoliticalVisage() {
		return politicalVisage;
	}
	public void setPoliticalVisage(String politicalVisage) {
		this.politicalVisage = politicalVisage;
	}

	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
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
