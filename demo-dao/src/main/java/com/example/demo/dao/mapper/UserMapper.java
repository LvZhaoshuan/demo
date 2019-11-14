package com.example.demo.dao.mapper;

import com.example.demo.dao.entity.UserDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author lvzhaoshuan
 * @date 2019/11/13
 */
@Repository
public interface UserMapper {

    /**
     * 根据主键ID查询
     *
     * @param id 主键ID
     * @return UserDO
     */
    UserDO selectById(@Param("id") Integer id);
}
