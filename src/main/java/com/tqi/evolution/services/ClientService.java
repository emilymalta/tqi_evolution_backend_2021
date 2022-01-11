package com.tqi.evolution.services;

import com.tqi.evolution.entities.Client;

import javax.servlet.http.HttpServletRequest;

public interface ClientService {
    Client findById(Long id);

    Client save(Client client);

    void delete(Long id);

    Client findByEmail(String email);

    Client findByRequestAuthorizationHeader(HttpServletRequest request);
}
