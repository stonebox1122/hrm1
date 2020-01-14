package com.stone.hrm.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * user实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_user")
@DynamicInsert
@DynamicUpdate
public class User implements Serializable, UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;//ID
	private String username;//员工工号
	private String password;//登录密码
	private Integer status;//状态：0为禁用，1为启用
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date createTime;//创建时间
	/**
	 * 注意：
	 * 1. 如果@ManyToMany不设置fetch = FetchType.EAGER会出现以下报错
	 * 	java.lang.RuntimeException: org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: com.stone.hrm.pojo.User.roles, could not initialize proxy - no Session
	 * 	java.lang.IllegalStateException: getWriter() has already been called for this response
	 *
	 * 	2. 如果不设置@JsonIgnoreProperties(value = { "users" })，会出现以下报错
	 * 	json序列化出错：com.stone.hrm.pojo.User@495a8cb0
	 * 	com.fasterxml.jackson.databind.JsonMappingException: failed to lazily initialize a collection of role: com.stone.hrm.pojo.Role.users, could not initialize proxy - no Session
	 *
	 */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_user_role",
			joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
	)
    @JsonIgnoreProperties(value = { "users" })
	private List<Role> roles = new ArrayList<>();

	public User() {
	}

	public User(String username, String password, Integer status, Date createTime) {
		this.username = username;
		this.password = password;
		this.status = status;
		this.createTime = createTime;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return true;
	}

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

}
