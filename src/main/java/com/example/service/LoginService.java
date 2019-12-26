package com.example.service;

import com.example.model.Users;
import com.example.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserPasswordHashClass userPasswordHashClass;

    @Autowired
    private UsersRepository usersRepository;

    public String login(String userId, String userPw) {
        if(userId.equals("") || userPw.equals("")) {
            return "login";
        }

        String hashPassword = userPasswordHashClass.getSHA256(userPw);
        Users user = usersRepository.findByUseridAndPassword(userId, hashPassword);
        if(user == null) {
            return "login";
        }

        return "index";
    }

}
