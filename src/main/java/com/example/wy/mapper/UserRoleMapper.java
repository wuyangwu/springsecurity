package com.example.wy.mapper;

import com.example.wy.entity.UserRole;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int insert(UserRole record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(UserRole record);

    /**
     *
     * @mbggenerated
     */
    UserRole selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(UserRole record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(UserRole record);
}