package com.stone.hrm.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * leavetype实体类
 * @author sl
 *
 */
@Table(name="tb_leavetype")
public class Leavetype implements Serializable {

	@Id
	private Integer id;//ID


	
	private String type;//请假类型

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}



}
