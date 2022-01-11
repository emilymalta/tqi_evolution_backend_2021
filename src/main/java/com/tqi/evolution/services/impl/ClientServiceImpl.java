package com.tqi.evolution.services.impl;

import com.tqi.evolution.entities.Client;
import com.tqi.evolution.exceptions.EntityNotFoundException;
import com.tqi.evolution.handlers.BCryptHandler;
import com.tqi.evolution.handlers.JwtTokenHandler;
import com.tqi.evolution.repositories.ClientRepository;
import com.tqi.evolution.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private JwtTokenHandler tokenHandler;

    public Client findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Client not found"));
    }

    public Client save(Client client) {
        client.setPassword(BCryptHandler.encryptPassword(client.getPassword()));
        return repository.save(client);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Client findByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("Client not found"));
    }

    public Client findByRequestAuthorizationHeader(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        String usernameFromToken = tokenHandler.getUsernameFromToken(token.split(" ")[1]);
        return this.findByEmail(usernameFromToken);
    }
}
