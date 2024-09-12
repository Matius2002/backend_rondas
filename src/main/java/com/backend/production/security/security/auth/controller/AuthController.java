package com.backend.production.security.security.auth.controller;

import com.backend.production.security.security.auth.jwt.TokenProvider;
import com.backend.production.security.security.auth.model.AccessToken;
import com.backend.production.security.security.auth.model.Login;
import com.backend.production.security.security.auth.model.SingupRequest;
import com.backend.production.security.security.auth.model.UserResponse;
import com.backend.production.security.security.auth.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "Auth", description = "Endpoind para la gestión de obtencion de Token")
@RestController
@RequestMapping
public class AuthController {

    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final TokenProvider tokenProvider;
    private final AuthService authService;


    public AuthController(AuthenticationManagerBuilder authenticationManagerBuilder, TokenProvider tokenProvider, AuthService authService){
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.tokenProvider = tokenProvider;

        this.authService = authService;
    }

    @PostMapping("/authentication")
    ResponseEntity<AccessToken> obtenerToken (@RequestBody Login login){

        UsernamePasswordAuthenticationToken username = new UsernamePasswordAuthenticationToken(
                login.username(),
                login.password()
        );

        System.out.println(" imprimer username -> " +username);
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(username);

        System.out.println(" imprimer username -> " +authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenProvider.crearToken(authentication);

        return ResponseEntity
                .ok()
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .body(new AccessToken(token));
    }

    @PostMapping("/sing-up")
    public ResponseEntity<?> singupUser(@RequestBody SingupRequest singupRequest) {

        if (authService.hasUserWithEmail(singupRequest.email())) {
            return new ResponseEntity<>("Usuario existe ", HttpStatus.NOT_ACCEPTABLE);
        }

        UserResponse userDto = authService.createUser(singupRequest);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }
}