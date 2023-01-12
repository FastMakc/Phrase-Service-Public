package com.example.phraseservicepublic.dao;

import com.example.phraseservicepublic.domen.dto.User;
import org.springframework.stereotype.Service;

@Service
public interface Dao {
    void addTag(String tag);
    void addPhraseTag(long phraseId, String tag);
    long addPhrase(long userId, String text);
    long getIdByToken(String accessToken);
    String getAccessToken(User user);
    boolean isExistsNickname(String nickname);

    void insertNewUser(User user);
}
