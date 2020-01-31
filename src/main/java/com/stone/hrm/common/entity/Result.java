package com.stone.hrm.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private boolean flag;//是否成功
    private Integer status;// 返回状态码
    private String message;//返回信息
    private Object data;// 返回数据

    public Result(boolean flag, Integer status, String message) {
        this.flag = flag;
        this.status = status;
        this.message = message;
    }
}

