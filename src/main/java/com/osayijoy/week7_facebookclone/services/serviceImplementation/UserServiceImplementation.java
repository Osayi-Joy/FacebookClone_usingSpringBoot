package com.osayijoy.week7_facebookclone.services.serviceImplementation;

import com.osayijoy.week7_facebookclone.models.User;
import com.osayijoy.week7_facebookclone.repositories.UserRepository;
import com.osayijoy.week7_facebookclone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void registerUser(User user) {
        userRepository.save(user);

    }

    @Override
    public User getuserByEmailAndPassWord(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
}
