package com.stone.hrm.dto;

import com.stone.hrm.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UserDto:
 *
 * @author Stone
 * @version V1.0
 * @date 2020/2/3
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto extends User {
    private Integer roleId;
}
