package lgarcia.dev.nutrigest_api.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lgarcia.dev.nutrigest_api.models.DTOs.Auth.AuthResponseDTO;
import lgarcia.dev.nutrigest_api.models.DTOs.Auth.LoginRequestDTO;
import lgarcia.dev.nutrigest_api.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public AuthResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO, HttpServletResponse response) {
        AuthResponseDTO authResponse = this.authService.login(loginRequestDTO.getEmail(), loginRequestDTO.getPassword());
        AuthResponseDTO cleanResponse = new AuthResponseDTO(authResponse.getRole(), authResponse.getUserId(), "Secret", "Secret");

        //Cookies de la peticion
        Cookie accessCookie = new Cookie("access_token", authResponse.getAccessToken());
        accessCookie.setHttpOnly(true);
        accessCookie.setPath("/");
        accessCookie.setMaxAge(3600);

        Cookie refreshCookie = new Cookie("refresh_token", authResponse.getRefreshToken());
        refreshCookie.setHttpOnly(true);
        refreshCookie.setPath("/");
        refreshCookie.setMaxAge(86400);

        Cookie roleCookie = new Cookie("role", authResponse.getRole());
        roleCookie.setHttpOnly(true);
        roleCookie.setPath("/");
        roleCookie.setMaxAge(3600);

        Cookie userIdCookie = new Cookie("user_id", String.valueOf(authResponse.getUserId()));
        userIdCookie.setHttpOnly(true);
        userIdCookie.setPath("/");
        userIdCookie.setMaxAge(3600);

        response.addCookie(accessCookie);
        response.addCookie(refreshCookie);
        response.addCookie(roleCookie);
        response.addCookie(userIdCookie);

        return cleanResponse;
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletResponse response) {
        Cookie accessCookie = new Cookie("access_token", null);
        accessCookie.setHttpOnly(true);
        accessCookie.setPath("/");
        accessCookie.setMaxAge(0);

        Cookie refreshCookie = new Cookie("refresh_token", null);
        refreshCookie.setHttpOnly(true);
        refreshCookie.setPath("/");
        refreshCookie.setMaxAge(0);

        Cookie roleCookie = new Cookie("role", null);
        roleCookie.setHttpOnly(true);
        roleCookie.setPath("/");
        roleCookie.setMaxAge(0);

        Cookie userIdCookie = new Cookie("user_id", null);
        userIdCookie.setHttpOnly(true);
        userIdCookie.setPath("/");
        userIdCookie.setMaxAge(0);

        response.addCookie(accessCookie);
        response.addCookie(refreshCookie);
        response.addCookie(roleCookie);
        response.addCookie(userIdCookie);

        return ResponseEntity.ok().build();
    }
}
