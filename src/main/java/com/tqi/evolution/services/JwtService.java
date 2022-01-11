package com.tqi.evolution.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    UserDetails loadUserByUsername(String username);
}