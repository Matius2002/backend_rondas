package com.backend.production.security.security.auth.model;

import com.backend.production.security.models.Rol;

public record UserResponse(
        Integer id,
        String email,
        String name,
        Rol userRole
) {

}
