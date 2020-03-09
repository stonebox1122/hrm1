package com.stone.hrm.dto;

import com.stone.hrm.pojo.Department;

/**
 * DepartmentDto:
 *
 * @author Stone
 * @version V1.0
 * @date 2020/3/9
 **/
public class DepartmentDto extends Department {
    private String organizationName; // 组织名称
    private String employeeName; // 用户姓名
    private String employeeUsername; // 用户工号

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeUsername() {
        return employeeUsername;
    }

    public void setEmployeeUsername(String employeeUsername) {
        this.employeeUsername = employeeUsername;
    }
}
