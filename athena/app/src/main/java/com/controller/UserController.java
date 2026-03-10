package com.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@Tag(name = "UserController", description = "API para obter dados do usuário autenticado")
@RestController
public class UserController {

    @GetMapping("/user")
    public Map<String, String> user(Authentication authentication) {
        Map<String, String> userInfo = new HashMap<>();
        if (authentication == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        OAuth2User principal = (OAuth2User) authentication.getPrincipal();
        userInfo.put("name", principal.getAttribute("name"));
        userInfo.put("email", principal.getAttribute("email"));
        return userInfo;
    }
}
