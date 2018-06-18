package com.otmoc.ubain.dao.generator;

import com.otmoc.ubain.model.LoginUser;

public interface LoginUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(LoginUser record);

    int insertSelective(LoginUser record);

    LoginUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(LoginUser record);

    int updateByPrimaryKey(LoginUser record);
}