package com.tqi.evolution.handlers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptHandler {
    public static String encryptPassword(String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(password);
    }
}
