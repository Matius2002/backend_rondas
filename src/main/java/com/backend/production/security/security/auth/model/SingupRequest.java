package com.backend.production.security.security.auth.model;

public record SingupRequest(
        String email,
        String password,
        String name
) {
}
