package com.otmoc.ubain.dao;

import com.otmoc.ubain.model.LoginUser;
import org.apache.ibatis.annotations.Param;

public interface LoginUserDao {
    LoginUser getUser(@Param("userName") String userName,
                      @Param("password") String password);
}
