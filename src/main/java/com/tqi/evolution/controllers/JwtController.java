package com.tqi.evolution.controllers;

import com.tqi.evolution.dtos.ClientAuthDTO;
import com.tqi.evolution.handlers.JwtTokenHandler;
import com.tqi.evolution.services.JwtService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtController {
    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtTokenHandler tokenHandler;

    @Autowired
    private JwtService jwtService;

    @ApiOperation("Responsavel pelo login no sistema.")
    @PostMapping("/authenticate")
    public ResponseEntity<?> createToken(@RequestBody ClientAuthDTO clientAuthDTO) {
        authenticate(clientAuthDTO.getUsername(), clientAuthDTO.getPassword());
        UserDetails userDetails = jwtService.loadUserByUsername(clientAuthDTO.getUsername());
        return ResponseEntity.ok(tokenHandler.assembleToken(userDetails));
    }

    private void authenticate(String username, String password) throws AuthenticationException {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }

}
