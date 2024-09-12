package com.backend.production.security.security.auth.model;

public record Login(
        String username,
        String password
) {
}