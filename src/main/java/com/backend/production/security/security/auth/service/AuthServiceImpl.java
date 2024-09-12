package com.backend.production.security.security.auth.service;


import com.backend.production.security.models.Rol;
import com.backend.production.security.models.Usuario;
import com.backend.production.security.repository.UsuarioRepository;
import com.backend.production.security.security.auth.model.SingupRequest;
import com.backend.production.security.security.auth.model.UserResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService{

    private final UsuarioRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthServiceImpl(UsuarioRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    @Override
    public UserResponse createUser(SingupRequest singupRequest) {
        Usuario user = new Usuario();

        user.setEmail(singupRequest.email());
        user.setNombre(singupRequest.name());
        user.setPassword(new BCryptPasswordEncoder().encode(singupRequest.password()));
        user.setRol(Rol.USER);
        user.setFechaCreacion(LocalDateTime.now());

        Usuario createUser = userRepository.save(user);

        return new UserResponse(user.getId(), user.getEmail(), user.getNombre(), user.getRol());

    }
    @Override
    public Boolean hasUserWithEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }

    @Override
    @PostConstruct
    public void createAcountAmdin() {
        Usuario adminAcount = userRepository.findByRol(Rol.ADMIN);

        if (null == adminAcount) {
            Usuario user = new Usuario();
            user.setEmail("admin@gmail.com");
            user.setRol(Rol.ADMIN);
            user.setNombre("Administrador");
            user.setFechaCreacion(LocalDateTime.now());
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(user);
        }
    }

    @Override
    public Optional<Usuario> findByEmailLogin(String email) {
        return userRepository.findByEmail(email);
    }

}
