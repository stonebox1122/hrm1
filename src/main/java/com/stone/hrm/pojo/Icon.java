package com.stone.hrm.pojo;

import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name="tb_icon")
@Repository
public class Icon implements Serializable {

	@Id
	private Integer id;//图标id
	private String name;//图标名称

	
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
}
