package com.stone.hrm.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * employeestate实体类
 * @author sl
 *
 */
@Table(name="tb_employeestate")
public class Employeestate implements Serializable {

	@Id
	private Integer id;//ID


	
	private String state;//员工状态

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}



}
