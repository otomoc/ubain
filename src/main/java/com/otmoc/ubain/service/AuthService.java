package com.otmoc.ubain.service;

import com.otmoc.ubain.model.LoginUser;

public interface AuthService {
    LoginUser getUser(String userName, String password);
}
