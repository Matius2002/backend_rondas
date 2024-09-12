package com.backend.production.security.security.auth.service;

import com.backend.production.security.models.Usuario;
import com.backend.production.security.security.auth.model.SingupRequest;
import com.backend.production.security.security.auth.model.UserResponse;

import java.util.Optional;

public interface AuthService {

    UserResponse createUser(SingupRequest singupRequest);
    Boolean hasUserWithEmail(String email);

    void createAcountAmdin();

    Optional<Usuario> findByEmailLogin(String email);
}
