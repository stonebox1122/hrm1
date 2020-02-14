package com.stone.hrm.dto;

import com.stone.hrm.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private List<Date> searchTime = new ArrayList<>(2);
}
