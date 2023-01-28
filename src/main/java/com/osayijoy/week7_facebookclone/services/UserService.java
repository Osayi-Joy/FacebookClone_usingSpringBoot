package com.osayijoy.week7_facebookclone.services;

import com.osayijoy.week7_facebookclone.models.User;

public interface UserService {
    User getUserByEmail(String email);
    void registerUser(User user);
    User getuserByEmailAndPassWord(String email, String password);
}
