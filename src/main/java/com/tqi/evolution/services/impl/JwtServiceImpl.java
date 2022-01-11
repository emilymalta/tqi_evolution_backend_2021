package com.tqi.evolution.services.impl;

import com.tqi.evolution.entities.Client;
import com.tqi.evolution.services.ClientService;
import com.tqi.evolution.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtServiceImpl implements UserDetailsService, JwtService {

    @Autowired
    private ClientService clientService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientService.findByEmail(username);
        return new User(username, client.getPassword(), new ArrayList<>());
    }
}
