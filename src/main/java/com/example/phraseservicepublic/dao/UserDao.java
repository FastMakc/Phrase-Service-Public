package com.example.phraseservicepublic.dao;

import com.example.phraseservicepublic.domain.dto.User;
import com.example.phraseservicepublic.domain.entity.Phrase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserDao {
    void addTag(String tag);
    void addPhraseTag(long phraseId, String tag);
    long addPhrase(long userId, String text);
    long getIdByToken(String accessToken);
    String getAccessToken(User user);
    boolean isExistsNickname(String nickname);

    void insertNewUser(User user);

    void addPhrasesTag(long phrasesId, String tag);

    List<Phrase> getPhrasesByUserId(long userId);

    List<String> getTagsByPhraseId(long phraseId);

    long getUserIdByPhraseId(long phraseId);

}
