package com.stone.hrm.dao;

import com.stone.hrm.dto.JobDto;
import com.stone.hrm.pojo.Job;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface JobMapper extends Mapper<Job> {

    List<JobDto> selectJobDtoAll();

    @Update("update tb_job set status = #{status} where id = #{id} ")
    void updateStatusById(@Param("status") Integer status, @Param("id") Integer id);
}
