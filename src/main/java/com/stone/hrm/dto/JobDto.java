package com.stone.hrm.dto;

import com.stone.hrm.pojo.Job;

/**
 * JobDto:
 *
 * @author Stone
 * @version V1.0
 * @date 2020/3/11
 **/
public class JobDto extends Job {
    private String departmentName;
    private String organizationName;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
}
