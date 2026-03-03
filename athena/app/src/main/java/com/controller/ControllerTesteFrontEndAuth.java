package com.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class ControllerTesteFrontEndAuth {


    @GetMapping("/teste")
    public String teste() {
        // Retorna src/main/resources/templates/teste.html
        return "teste";
    }


}
