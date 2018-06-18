package com.otmoc.ubain.service.impl;

import com.otmoc.ubain.dao.LoginUserDao;
import com.otmoc.ubain.model.LoginUser;
import com.otmoc.ubain.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private LoginUserDao loginUserDao;

    @Override
    public LoginUser getUser(String userName, String password) {
        return loginUserDao.getUser(userName, password);
    }
}
