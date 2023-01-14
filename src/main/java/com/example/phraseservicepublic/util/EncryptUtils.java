package com.example.phraseservicepublic.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Slf4j
@Service
@RequiredArgsConstructor
public class EncryptUtils {
    public String encryptPassword(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }
}