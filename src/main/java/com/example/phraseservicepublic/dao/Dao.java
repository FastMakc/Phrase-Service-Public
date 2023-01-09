package com.example.phraseservicepublic.dao;

import org.springframework.stereotype.Service;

@Service
public interface Dao {

    boolean isExistsNickname(String nickname);

    void insertNewUser(User user);
}
