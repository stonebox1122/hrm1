package com.stone.hrm.dto;

import com.stone.hrm.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * UserDto:
 *
 * @author Stone
 * @version V1.0
 * @date 2020/2/3
 **/

public class UserDto extends User {
    private Integer roleId;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date beginCreateTime;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endCreateTime;

    public UserDto() {
    }

    public UserDto(Integer roleId, Date beginCreateTime, Date endCreateTime) {
        this.roleId = roleId;
        this.beginCreateTime = beginCreateTime;
        this.endCreateTime = endCreateTime;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Date getBeginCreateTime() {
        return beginCreateTime;
    }

    public void setBeginCreateTime(Date beginCreateTime) {
        this.beginCreateTime = beginCreateTime;
    }

    public Date getEndCreateTime() {
        return endCreateTime;
    }

    public void setEndCreateTime(Date endCreateTime) {
        this.endCreateTime = endCreateTime;
    }
}
